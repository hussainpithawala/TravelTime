import React from 'react';

var LayoverData = React.createClass({
    render:function () {
        var layOver;
        var i = 1;
        for(var key in this.props.layoverTime){
            if(i == this.props.index) {
                layOver = this.props.layoverTime[key];
            }
            i++;
        }
        return (<p className="col-12 dottedLine">
            <span> LayOver Time -> {layOver} </span>
        </p>);
    }
});

var ItineraryDetails = React.createClass({
    render: function () {
        var itinerary = this.props.itinerary;
        var rowStyle = {top_border: '1px dotted black'};
        return (
            <div id="itineraryDetails">
                {itinerary[0].outbound.flights.map(function(flight, index) {
                    var layover;
                    if (index != 0 ){
                        layover = <LayoverData index = {index} layoverTime = {itinerary[0].outbound.layovers}></LayoverData>
                    }
                    else  {
                        layover = null;
                    }
                    return (
                        <div className="row itinerary" key={index}>
                            <div>{layover}</div>
                            <div className="col-xs-1">{flight.operating_airline}</div>
                            <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                {flight.departs_at}
                                <br/>
                                <span>{flight.origin.airport}</span>
                            </div>
                            <i className="col-2 col-sm-2 col-md-2 col-lg-2 fa fa-arrow-right" aria-hidden="true"></i>
                            <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                {flight.arrives_at}
                                <br/>
                                <span>{flight.destination.airport}</span>
                            </div>
                            <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">{flight.duration}
                            <br/>
                                <span className="travelClass">{flight.booking_info.travel_class}</span>
                            </div>
                        </div>
                    )
                })}
            </div>
        )
    }
});

var FareDetails =  React.createClass({
    render: function () {
        return (<div id="fareDetails">
            <div className="row" style={this.props.rowStyle}>
                <div className="col-sm-3">Price per adult</div>
                <div className="col-sm-2">{this.props.fare}</div>
            </div>
            <div className="row" style={this.props.rowStyle}>
                <div className="col-sm-3">Service Tax</div>
                <div className="col-sm-2">{this.props.tax}</div>
            </div>
            <div className="row" style={this.props.rowStyle}>
                <div className="col-sm-3">Total Price</div>
                <div className="col-sm-2">{this.props.totalPrice}</div>
            </div>
        </div>)
    }
});

var ViewDetails = React.createClass({
    render:function () {
        var component;
        var rowStyle = {padding: '1%'};
        var fare = this.props.flightInfo.fare.price_per_adult.total_fare - this.props.flightInfo.fare.price_per_adult.tax;
        var tax = this.props.flightInfo.fare.price_per_adult.tax;
        var total_price = this.props.flightInfo.fare.total_price;
        if (this.props.view != 'fare') {
            component = <ItineraryDetails itinerary={this.props.flightInfo.itineraries}></ItineraryDetails>
        }
        else {
            component = <FareDetails rowStyle= {rowStyle} fare={fare} tax={tax} totalPrice = {total_price}></FareDetails>
        }
        return (
            <div id="viewDetails">
                {component}
            </div>)
    }
});

var FlightDetails = React.createClass({
    getInitialState:function () {
        return {
            view :'fare'
        }
    },
    onBtnClick: function (e) {
        if(e.target.name == 'fare'){
            this.setState({
                view: 'fare'
            })
        } else {
            this.setState({
                view: 'itinerary'
            })
        }
    },
    render:function () {
        var btnStyle = {
            color: 'black',
            border: '1px solid black',
            float: 'left',
            padding: '2px'
        };
        return(
            <div id={this.props.id} className="collapse flightDetails">
                <div id="infoTitle">
                    <button name = "itinerary" style={btnStyle} onClick={this.onBtnClick}>
                        ITINERARY
                    </button>
                    <button name = "fare" style={btnStyle} onClick={this.onBtnClick}>
                        FARE DETAILS
                    </button>
                </div>
                <br/>
                <ViewDetails view={this.state.view} flightInfo={this.props.flightInfo}></ViewDetails>
            </div>
        )
    }
});
var FlightHeading = React.createClass({
    getInitialState : function() {
        return {showDetails : false};
    },

    OnViewDetailsClick : function () {
        this.setState({ showDetails : true});
    },

    OnHideDetailsClick : function () {
        this.setState({showDetails: false});
    },

    render:function () {
        var length = this.props.flightData.length;
        var arrivalTime = this.props.flightData[length - 1].arrives_at;
        var destAirport = this.props.flightData[length - 1].destination.airport;
        var toggledetails;

        if (!this.state.showDetails) {
            toggledetails = <span onClick={this.OnViewDetailsClick}> +Show Details</span>
        } else {
            toggledetails = <span onClick={this.OnHideDetailsClick}> -Hide Details</span>
        }

        return (
            <div className="row" data-toggle="collapse" data-target={this.props.target}>
                <div className="col-xs-1">{this.props.flightData[0].operating_airline}</div>
                <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    {this.props.flightData[0].departs_at}
                    <br/>
                    <span>{this.props.flightData[0].origin.airport}</span>
                </div>
                <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    {arrivalTime}
                    <br/>
                    <span>{destAirport}</span>
                </div>
                <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">{this.props.duration}</div>
                <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">{this.props.totalPrice} USD</div>
                <div className="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                    <span id="toggleContent">{toggledetails}</span>
                </div>
            </div>
        )
    }
});
var Flight = React.createClass({
    render:function () {
        var flightData = this.props.flightdata.itineraries[0].outbound.flights;
        var duration = this.props.flightdata.itineraries[0].outbound.duration;
        var totalPrice = this.props.flightdata.fare.total_price;
        var id = "info" + this.props.index;
        var target = "#info" + this.props.index;
        return (<div id="flightInfo">
            <FlightHeading target={target} duration = {duration} flightData={flightData} totalPrice={totalPrice}></FlightHeading>
            <FlightDetails id={id} flightInfo={this.props.flightdata}></FlightDetails>
        </div>)
    }
});

var List = React.createClass({
    render:function () {
        return(
            <div className="flightList">
                {this.props.data.map(function(flightData, index) {
                    return (<Flight key={index} index={index} flightdata={flightData}/>)
                })}

            </div>
        )
    }
});
var ListHeading = React.createClass({
    render:function () {
        return (
            <div id="heading">
                <div className="row">
                    <div className="col-xs-1"></div>
                    <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">DEPARTURE</div>
                    <div className="col-xs-3 col-sm-2 col-md-3 col-lg-3">ARRIVAL</div>
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">DURATION</div>
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">PRICE</div>
                    <div className="col-xs-1 col-sm-1 col-md-1 col-lg-1"></div>
                </div>
            </div>
        )
    }
});

var FlightsList = React.createClass({
    render:function () {
        return (<div className="flightsPanel">
            <div className="row flightsPanelHeading">
                <div className="col-xs-6">
                    <span id="mainText">Flights Result</span>
                </div>
                <div className = "col-xs-6">
                    <button id = "backButton" className="btn btn-primary pull-right" onClick= {this.props.onBackBtnClick}>
                    Back
                    </button>
                </div>
            </div>
            <div id="flightsContent">
                <ListHeading></ListHeading>
                <List data={this.props.flightsData.results}></List>
            </div>
        </div>)
    }
});

export default FlightsList;