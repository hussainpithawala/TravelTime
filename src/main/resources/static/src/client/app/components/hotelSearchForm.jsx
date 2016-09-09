import React from 'react';
import LocationsDataList from '../components/locationList.jsx';
import NumberSelector from '../helpercomponents/numberSelector.jsx';
import TextInput from '../helpercomponents/textInput.jsx';

var HotelSearchForm = React.createClass({
  // get initial state event
  getInitialState: function() {
    return {
      check_in:'',
      check_out:'',
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
        "check_in"  : this.state.check_in,
        "check_out" : this.state.check_out,
        "location" : this.state.location
      };
      this.props.updateSearchResult(requestJSON);
    }
    console.log("Submitted!!");
  },
  // handle change from-date
  onChangeFromDate: function (date) {
    this.setState({
      check_in: date
    });
    if (new Date(date) > new Date(this.state.check_out)) {
      this.setState({
        check_out: date
      });
    }
  },
  // handle change to-date
  onChangeToDate: function (date) {
    this.setState({
      check_out: date
    });
  },

  // handle location change here
  onChangeLocation: function (location) {
    var me = this;
    this.props.updateLocations(location);
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
          <form id="flightsearch" onSubmit={this.handleSubmit} className="row col-sm-12 ">
              <div className="row col-sm-12 col-centered">
                  <h1>Book Hotels</h1>
              </div>
              <div className="row col-xs-12 col-centered">
                  <TextInput type="text" value={this.state.location} label={Location} name={'Location'}
                             htmlFor={'Location'} isRequired={true} onChange={this.onChangeLocation}
                             onComponentMounted={this.register} messageRequired={'Location Required'}
                             list={'locations'}
                  />
                  <LocationsDataList id="locations"/>
                  <div className="col-xs-3">
                      <label htmlFor="Rooms">
                          ROOMS
                      </label>
                      <NumberSelector from="1" to="9" value="1" id="rooms" onChange={this.onChangeRooms}/>
                  </div>
                  {/*<TextInput type="text" value={this.state.referencePoint} label={'Reference Point'} name={'ReferencePoint'}
                              htmlFor={'ReferencePoint'} isRequired={false} messageRequired={''}
                   />*/}
              </div>
              <div className="row col-xs-12 col-centered">
                  <TextInput type="date" value={this.state.check_in} label={'Check-In'} name={'CheckIn'}
                             htmlFor={'CheckIn'} isRequired={true} onChange={this.onChangeFromDate}
                             onComponentMounted={this.register} messageRequired={'Check-in required'}
                  />
                  <TextInput type="date" value={this.state.check_out} label={'Check-Out'} name={'CheckOut'}
                             htmlFor={'CheckOut'} isRequired={true} onChange={this.onChangeToDate}
                             onComponentMounted={this.register} messageRequired={'Check-out required'}
                             min={this.state.check_in}
                  />
              </div>
              {/*<div className="row col-xs-12 col-centered ">
                <div className="col-xs-3">
                  <label htmlFor="dep">Max Wait:</label>
                  <input type="number" className="form-control" id="Max Wait:" min="1" max="1600" placeholder="Max 1600ms " />
                </div>
                <div className="col-xs-3">
                  <label htmlFor="Rooms">
                    ROOMS
                  </label>
                  <NumberSelector from="1" to="9" value="1" id="rooms" onChange={this.onChangeRooms}/>
                </div>
                <div className="col-xs-3">
                  <label htmlFor="Cribs">
                    Cribs
                  </label>
                  <NumberSelector from="0" to="9" value="0" id="Cribs" />
                </div>
                <div className="col-xs-3">
                  <label htmlFor="Rollaway Beds">
                    Rollaway Beds
                  </label>
                  <NumberSelector from="0" to="9" value="0" id="Rollaway Beds"/>
                </div>
              </div>*/}

              <div className="row col-xs-12 col-centered">
                  <div className="col-sm-3">
                      <button type="submit" className="btn btn-primary btn-block" id="submit">Search</button>
                  </div>
              </div>
          </form>
        );
  }
});
export default HotelSearchForm;
