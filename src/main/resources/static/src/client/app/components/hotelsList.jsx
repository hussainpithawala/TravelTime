import React from 'react';

var HotelDetails = React.createClass({
render: function () {
    var hotelDetails = this.props.details;
    return (<div id="hotelInfo" className="row">
        <div className="col-sm-4">
            <h6> <b>Address: </b> </h6>
            <p> {this.props.details.address.line1} {hotelDetails.address.city}</p>
        </div>
        <div className="col-sm-8">
            <h6> <b>Contact: </b> </h6>
            <p> {this.props.details.contacts[0].detail}</p>
        </div>
    </div>)}
});

var Room = React.createClass({
    handleChange: function (e) {
        this.props.changedRoomRate(e.target.value);
    },
    render: function() {
        var text = "";
        for (var i = 0; i < this.props.data.descriptions.length; i++) {
            text = text  + this.props.data.descriptions[i] + ". ";
        }
        return (<div className="row">
                <input className="col-sm-4" type="radio" name="room" value={this.props.data.total_amount.amount} onChange={this.handleChange} />
                <p id="price">{this.props.data.total_amount.amount} "$"</p>
                <p className="col-sm-7" id="roomType"> {this.props.data.room_type_info.room_type} </p>
                <p className="col-sm-7" id="roomDescription">{text}</p>
            </div>
        );
    }
});
var RoomsDetails = React.createClass({
    getInitialState: function() {
        return {
            selectedRoomRate: this.props.roomsData.rooms[0].total_amount.amount
        }
    },
    changedRoomRate: function(rate) {
        this.setState({
            selectedRoomRate: rate
        });
    },

    render: function() {
        var this_= this;
        return (
          <div id="roomInfo">
              <h6> <b>SELECT NIGHTLY RATE </b></h6>
              {this.props.roomsData.rooms.map(function(result) {
                  return <Room key={result.room_type_code} data={result}  changedRoomRate={this_.changedRoomRate}/>;
              })}
              <p id="selectedRoomRate">{this.state.selectedRoomRate} "USD"</p>
          </div>
        );
    }
});

var Section = React.createClass({

    getInitialState: function() {
        return { showToolTip: false };
    },
    componentDidMount: function() {
        var acc = document.getElementsByClassName("accordion");
        var i;

        for (i = 0; i < acc.length; i++) {
            acc[i].onclick = function(e){
                this.classList.toggle("active");
                this.nextElementSibling.classList.toggle("show");
            }
        }
    },

    cardShow: function (e) {
        this.setState({
            showToolTip:true
        });
    }
    ,
    cardHide: function (e) {
        this.setState({
            showToolTip:false
        });
    },
    render: function() {
        return (
          <div>
              <div className="accordion" title={this.props.data.min_daily_rate.amount}>{this.props.data.property_name}
                  <i className="fa fa-info" aria-hidden="true" onMouseEnter={this.cardShow}
                     onMouseLeave={this.cardHide}></i>
                  {this.state.showToolTip? <Tooltip data={this.props.data}/>:null}
              </div>
              <div className="panel">
                  <HotelDetails details={this.props.data}/>
                  <RoomsDetails roomsData={this.props.data}/>
              </div>
          </div>
        );
    }
})

var Tooltip = React.createClass({
    buildToolTip: function(data){
        var text = data.rooms.map(function (info) {
            return <li key={info.room_type_code}>{info.room_type_info.room_type} - {info.total_amount.amount} $</li>
        })
        return text;
    },

    render:function () {
        var toolTipText = this.buildToolTip(this.props.data);
        return (
          <div className="tooltiptext" ref="myinput">
              {toolTipText}
          </div>
        );
    }
});

var Container = React.createClass({
    buildSections: function(sectionList){
        var sections = sectionList.map(this.buildSection);
        return sections;
    },
    buildSection: function(section){
        /* Remember to add a 'key'. React wants you to add an identifier when you instantiate a component multiple times */
        return <Section key={section.property_code} data={section} />
    },
    render: function() {
        var sections = this.buildSections(this.props.data);
        return (
          <div className="Results">
              {sections}
          </div>
        );
    }
});

var HotelSearchResult = React.createClass({

    getInitialState: function() {
        return {
            backendData: this.props.searchResult
        }
    },

    propertiesChanged: function(reloadedResult) {
        if (reloadedResult) {
            this.setState({
                backendData: reloadedResult
            })
        }
    },

    componentWillReceiveProps: function(nextProps) {
        this.propertiesChanged(nextProps.searchResult)
    },
    render: function() {
        return (
          <div className="col-sm-8" id="mainPanel">
              <p className="flow-text" id="mainText">Shop Results </p>
              <h5 id="note">LOWEST AVAILABLE NIGHTLY RATE PER ROOM</h5>
              <Container id = "backendData" data={this.state.backendData}></Container>
          </div>
        );
    }
});

export default HotelSearchResult;
