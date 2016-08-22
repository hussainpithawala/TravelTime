import React from 'react';

var inputstyles = {width:"130px"};
var paddingInitial = {padding: 'initial'};
var NumberSelector = React.createClass({
  getInitialState: function() {
    //this.getOptions = this.getOptions.bind(this);
    return null;
  },
  getOptions : function () {
    var options = [];
    for(let i = this.props.from; i <= this.props.to; i++) {
      options.push(<option key={i} value={i}>{i}</option>)
    }
    return options;
  },
  render: function () {
    return (
      <select className="browser-default" id={this.props.id}>
        {this.getOptions()}
      </select>
    );
  }
});

var TextInput = React.createClass({
  // onChange event handling
  handleChange: function(e) {
    this.props.onChange(e.target.value);
    var isValidField = this.isValid(e.target);
  },
  // validation function
  isValid: function(inputValue) {
    // check required fields
    if ((inputValue.getAttribute('required') != null) && (inputValue.value = '')) {
      inputValue.classList.add('error'); // add error class
      inputValue.nextSibling.textContent = this.props.messageRequired; // Show error message
      return false;
    } else {
      inputValue.classList.remove('error'); // remove error class
      inputValue.nextSibling.textContent = '';
    }
    return true;
  },
  componentDidMount: function(){
    if (this.props.onComponentMounted) {
      this.props.onComponentMounted(this);
    }
  },
  render: function() {
    var inputField;
    if (this.props.type == 'text') {
      inputField = <input value={this.props.value} name={this.props.name} placeholder={this.props.name}
        ref={this.props.name} required = {this.props.isrequired} onChange = {this.handleChange}
        style={inputstyles} id={this.props.name}/>
    } else if(this.props.type == 'date' ) {
      inputField = <input type="date" value={this.props.value} name={this.props.name} placeholder={this.props.name}
                          ref={this.props.name} required = {this.props.isrequired} onChange = {this.handleChange}
                          style={inputstyles} id={this.props.name} data-type="date" min={this.props.min}/>
    }
    return (
      <div className="mdl-cell mdl-cell--6-col">
        <span className="field">{this.props.name} :</span>
        {inputField}
        <span className="error"></span>
      </div>
    )
  }
});

var HotelSearchForm = React.createClass({
  // get initial state event
  getInitialState: function() {
    return {
      checkIn:'',
      checkOut:'',
      location:'',
      rooms:0,
      serverMessage:'',
      Fields:[]
    };
  },
  // handle form submit event here
  handleSubmit: function (e) {
    // handle submit action here
    e.preventDefault(); // prevent default actions for <form> tag
    // validate entire search form here
    var validForm = true;
    this.state.Fields.forEach(function(field){
      if (typeof field.isValid === "function") {
        var validField = field.isValid(field.refs[field.props.name]);
        validForm = validForm && validField;
      }
    });
    // send post request to server
    if (validForm) {
      var requestJSON = {
        "checkIn"  : this.state.checkIn,
        "checkOut" : this.state.checkOut,
        "location" : this.state.location
      };
      this.props.updateSearchResult(requestJSON);
    }
    console.log("Submitted!!");
  },
  // handle change from-date
  onChangeFromDate: function (date) {
    this.setState({
      checkIn: date
    });
    if (new Date(date) > new Date(this.state.checkOut)) {
      this.setState({
        checkOut: date
      });
    }
  },
  // handle change to-date
  onChangeToDate: function (date) {
    this.setState({
      checkOut: date
    });
  },

  // handle location change here
  onChangeLocation: function (location) {
    var me = this;
    $(function () {
      var getData = function (request, response) {
        $.getJSON(
          "rest/get/airportAutocomplete?term=" + location,
          function (data) {
            response(data);
          });
      };

      var selectItem = function (event, ui) {
        $("#Location").val(ui.item.value);
        console.log(ui.item.value);
        me.setState({location: ui.item.value});
        return true;
      };

      $("#Location").autocomplete({
        source: getData,
        select: selectItem,
        minLength: 2
      });
    });
    this.setState({
      location: location
    });
    console.log("changed location");
  },
  // handle rooms change here
  onChangeRooms:  function (rooms) {
    this.setState({
      rooms: rooms
    });
    console.log("changed rooms")
  },
  // register input controls
  register: function (field) {
    var states = this.state.Fields;
    states.push(field);
    this.setState({
      Fields: states
    })
  },
  render: function() {
    return (
      <div className="collapsible" id="generalSearchPanel">
        <button id="collapsibleBtn"></button>
        <div id="searchPanel">
          <form onSubmit={this.handleSubmit}>
            <div id="searchPanel1">
              <label className="mdl-checkbox" htmlFor="checkbox1">
                <input type="checkbox" id="checkbox1" className="mdl-checkbox__input" defaultChecked/>
                <span className="mdl-checkbox__label">Hotel</span>
              </label>
              <div className="mdl-grid" style={ paddingInitial }>
                <div className="mdl-cell mdl-cell--12-col">
                  <span>Standard Hotel Shipping</span>
                  <br/>
                </div>
                <TextInput type="text" value={this.state.location} label={Location} name={'Location'}
                           htmlFor={'Location'} isRequired={true} onChange={this.onChangeLocation}
                           onComponentMounted={this.register} messageRequired={'Location Required'}
                />
                <TextInput type="text" value={this.state.referencePoint} label={'Reference Point'} name={'ReferencePoint'}
                           htmlhtmlFor={'ReferencePoint'} isRequired={false} messageRequired={''}
                />
                  <TextInput type="date" value={this.state.checkIn} label={'Check-In'} name={'CheckIn'}
                             htmlFor={'CheckIn'} isRequired={true} onChange={this.onChangeFromDate}
                             onComponentMounted={this.register} messageRequired={'Check-in required'}
                  />
                  <TextInput type="date" value={this.state.checkOut} label={'Check-Out'} name={'CheckOut'}
                             htmlFor={'CheckOut'} isRequired={true} onChange={this.onChangeToDate}
                             onComponentMounted={this.register} messageRequired={'Check-out required'}
                             min={this.state.checkIn}
                  />
                <div className="mdl-cell mdl-cell--6-col">
                  <span className="field">Rooms:</span>
                  <div className="mdl-selectfield">
                    <label>Standard Select</label>
                    <NumberSelector from="1" to="9" id="Rooms"/>
                  </div>
                </div>
                <div className="mdl-cell mdl-cell--6-col">
                  <span className="field">Max Wait:</span>
                  <input type="text" name="MaxWt" placeholder="16000 ms" style={inputstyles} />
                </div>
                <div className="mdl-cell mdl-cell--3-col">
                  <span className="field">Cribs:</span>
                  <div className="mdl-selectfield">
                    <label>Standard Select</label>
                    <NumberSelector from="0" to="9" id="Cribs"/>
                  </div>
                </div>
                <div className="mdl-cell mdl-cell--8-col">
                  <span className="field">Rollaway Beds:</span>
                  <div className="mdl-selectfield">
                    <label>Standard Select</label>
                    <NumberSelector from="0" to="9" id="RollawayBeds"/>
                  </div>
                </div>
                <div className="mdl-cell mdl-cell--4-col">
                  <button className="mdl-button mdl-button--raised" id="submit">Search</button>
                </div>
              </div>
            </div>
          </form>
        </div>
      </div>
    );
  }
});
export default HotelSearchForm;