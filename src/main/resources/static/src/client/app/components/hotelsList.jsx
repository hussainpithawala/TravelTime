import React from 'react';

var Room = React.createClass({
    render: function() {
        return (<div >
                <p id="roomType">
                    <span id = "label"> Room Type: </span>
                    { " " + this.props.data.room_type_info.room_type}
                    <br/>
                    <span id = "label"> Price:
                        { " $ " + this.props.data.rates[0].price }
                    </span>
                    <br/>
                    <span id = "label"> Room Description: </span>
                    <br/>
                    {
                        this.props.data.descriptions.map(function(result) {
                            return <li key = {result} > {result} </li>;
                        })
                    }
                </p>
            </div>
        );
    }
});

var LoadRooms = React.createClass({
    render: function () {
        var roomDetails = this.props.roomdetails;
        var id = "room" + this.props.index;
        var target = "#" + id;

        return(
            <div id = "hotelInfo" className = "row">
                <button id = "loadrooms" type = "button" className = "btn btn-info" data-toggle = "collapse"
                        data-target = {target}>
                    Load Rooms
                </button>

                <div id = {id} className = "collapse">
                    <div className = "col-sm-8">
                        {roomDetails.rooms.map(function(result) {
                            return <Room key = {result.room_type_code} data = {result}/>;
                        })}
                    </div>
                    <div className = "col-sm-3 pull-right">
                        <p> Total Price:
                            <span id = "selectedRoomRate">
                               { " $ " + roomDetails.total_price.amount}
                           </span >
                        </p>
                    </div>
                </div>
            </div>
        )
    }
});

var HotelAddress = React.createClass({
    render: function () {
        var hotelAddress = this.props.hoteladdress.address;

        return (
            <div id = "hotelInfo" className = "row">
                <div className = "col-md-10 col-sm-10 col-xs-10">
                    <p id = "address">
                        {hotelAddress.line1 + ", "} {hotelAddress.city + ", "}
                        {hotelAddress.region + ", "} {hotelAddress.country + "-"}
                        {hotelAddress.postal_code}
                        <br />
                        <b> Contact: </b> {this.props.hoteladdress.contacts[0].detail}
                    </p>
                </div>

                <div className = "col-md-2 col-sm-2 col-xs-3 pull-right">
                    <div id = "selectedRoomRate">
                        { "$ " + this.props.hoteladdress.min_daily_rate.amount}
                    </div >
                    <p id = "text">per room / night</p>
                </div>
            </div>
        )
    }
});

var HotelDetails = React.createClass({
    render: function () {
        var hotelDetails = this.props.details;

        return (
            <div>
                <HotelAddress hoteladdress = {hotelDetails}/>
                <LoadRooms roomdetails = {hotelDetails} index = {this.props.index} />
            </div>
        );
    }
});

var Section = React.createClass({

    getInitialState : function() {
        return {showDetails : false};
    },

    OnViewDetailsClick : function () {
        this.setState({ showDetails : true});
    },

    OnHideDetailsClick : function () {
        this.setState({showDetails: false});
    },

    render: function() {
        var id = "hotelinfo" + this.props.index;
        var target = "#" + id;
        var toggledetails;

        if (!this.state.showDetails) {
            toggledetails = <span onClick={this.OnViewDetailsClick}> +Show Details</span>
        } else {
            toggledetails = <span onClick={this.OnHideDetailsClick}> -Hide Details</span>
        }

        return (
          <div id = "hotelSearchResult">
              <div id = "propertyName" className = "row" data-toggle = "collapse" data-target = {target}>
                  {this.props.data.property_name}
                  <div id= "toggleContent"className="col-sm-2 pull-right">{toggledetails}</div>
              </div>
              <div className = "collapse " id = {id}>
                  <HotelDetails details = {this.props.data} index = {this.props.index}/>
              </div>
          </div>
        );
    }
});

var Container = React.createClass({
    render: function() {
        return (
            <div className = "flightList">
                {this.props.data.map(function(hotelData, index) {
                    return (<Section key = {hotelData.property_code} index = {index} data = {hotelData} />)
                })}
            </div>
        )
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
          <div>
              <Container id = "backendData" data = {this.state.backendData} ></Container>
          </div>
        );
    }
});

export default HotelSearchResult;
