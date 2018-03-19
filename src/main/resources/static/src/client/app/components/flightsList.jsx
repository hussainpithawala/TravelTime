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
        var layover = this.props.layover;
        return (
            <div id="itineraryDetails">
                {itinerary.flights.map(function(flight, index) {
                    var layoverInfo;
                    if (index != 0 ){
                        layoverInfo = <LayoverData index = {index} layoverTime = {layover}></LayoverData>
                    }
                    else  {
                        layoverInfo = null;
                    }
                    return (
                        <div className="row itinerary" key={index}>
                            <div>{layoverInfo}</div>
                            <div className="col-xs-1">{flight.operating_airline}</div>
                            <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                {flight.departs_at}
                                <br/>
                                <span>{flight.origin.airport_name_city}</span>
                            </div>
                            <i className="col-2 col-sm-2 col-md-2 col-lg-2 fa fa-arrow-right" aria-hidden="true"></i>
                            <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                                {flight.arrives_at}
                                <br/>
                                <span>{flight.destination.airport_name_city}</span>
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
    getInitialState:function () {
        return {
            view :'itinerary'
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
        var component;
        var rowStyle = {padding: '1%'};
        var fare = this.props.flightInfo.fare.price_per_adult.total_fare - this.props.flightInfo.fare.price_per_adult.tax;
        var tax = this.props.flightInfo.fare.price_per_adult.tax;
        var total_price = this.props.flightInfo.fare.total_price;
        var btnStyle = {
            color: 'black',
            border: '1px solid black',
            float: 'left',
            padding: '2px'
        };
        var divStyle = (this.props.flightInfo.itineraries[0].inbound) ? {border : '1px dotted black' } : null;
        if (this.state.view != 'fare') {
            component = <ItineraryDetails itinerary={this.props.itinerary} layover={this.props.layover}></ItineraryDetails>
        }
        else {
            component = <FareDetails rowStyle= {rowStyle} fare={fare} tax={tax} totalPrice = {total_price}></FareDetails>
        }
        return (
            <div style={divStyle}>
                <div id="infoTitle">
                    <button name = "itinerary" style={btnStyle} onClick={this.onBtnClick}>
                        ITINERARY
                    </button>
                    <button name = "fare" style={btnStyle} onClick={this.onBtnClick}>
                        FARE DETAILS
                    </button>
                </div>
                <br/>
                <div  id="viewDetails">
                    {component}
                </div>
            </div>)
    }
});

var FlightDetails = React.createClass({
    getInitialState:function () {
        return {
            view :'outbound',
            itinerary: this.props.flightInfo.itineraries[0].outbound,
            layover: this.props.flightInfo.itineraries[0].outbound.layovers
        }
    },
    onBtnClick: function (e) {
        if(e.target.name == 'outbound'){
            this.setState({
                view: 'outbound',
                itinerary: this.props.flightInfo.itineraries[0].outbound,
                layover:this.props.flightInfo.itineraries[0].outbound.layovers
            })
        } else {
            this.setState({
                view: 'inbound',
                itinerary: this.props.flightInfo.itineraries[0].inbound,
                layover:this.props.flightInfo.itineraries[0].inbound.layovers
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
        var divStyle = {
            marginBottom: '2%'
        };

        var inbndoOutbnddtls = (this.props.flightInfo.itineraries[0].inbound)? <div style={divStyle}>
            <button name = "outbound" style={btnStyle} onClick={this.onBtnClick}>
                OUTBOUND DETAILS
            </button>
            <button name = "inbound" style={btnStyle} onClick={this.onBtnClick}>
                INBOUND DETAILS
            </button>
        </div> : null;

        return(
            <div id={this.props.id} className="collapse flightDetails">
                {inbndoOutbnddtls}
                {(inbndoOutbnddtls)? <br/> : null}
                <ViewDetails view={this.state.view} layover={this.state.layover} flightInfo={this.props.flightInfo} itinerary={this.state.itinerary}></ViewDetails>
            </div>
        )
    }
});

var ReturnFlightHeading = React.createClass({
    render: function () {
        var length = this.props.inboundFlightData.length;
        var arrivalTime = this.props.inboundFlightData[length - 1].arrives_at;
        var destAirport = this.props.inboundFlightData[length - 1].destination.airport_name_city;
        return(
            <div>
                <div id="dottedBorder"></div>
                <span id="returnFlight">Return Flight</span>
                <br/>
                <div className="row returnFlightHeading">
                    <div className="col-xs-1">{this.props.inboundFlightData[0].operating_airline}</div>
                    <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        {this.props.inboundFlightData[0].departs_at}
                        <br/>
                        <span>{this.props.inboundFlightData[0].origin.airport_name_city}</span>
                    </div>
                    <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                        {arrivalTime}
                        <br/>
                        <span>{destAirport}</span>
                    </div>
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">{this.props.inboundDuration}</div>
                    {/*<div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">{} USD</div>*/}
                </div>
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
        var destAirport = this.props.flightData[length - 1].destination.airport_name_city;
        var toggledetails;
        if (!this.state.showDetails) {
            toggledetails = <span onClick={this.OnViewDetailsClick}> +Show Details</span>
        } else {
            toggledetails = <span onClick={this.OnHideDetailsClick}> -Hide Details</span>
        }

        var returnFlight = (this.props.inboundFlightData)? <ReturnFlightHeading inboundFlightData={this.props.inboundFlightData} inboundDuration={this.props.inboundDuration}></ReturnFlightHeading>:null;

        return (
            <div className="row" data-toggle="collapse" data-target={this.props.target}>
                {(returnFlight) ? <span id="ownwardFlight">Ownward Flight</span> : null}
                {(returnFlight) ? <div id="break"><br/></div> : null}
                <div className="col-xs-1">{this.props.outboundFlightData[0].operating_airline}</div>
                <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    {this.props.outboundFlightData[0].departs_at}
                    <br/>
                    <span>{this.props.outboundFlightData[0].origin.airport_name_city}</span>
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
                <div>
                    {returnFlight}
                </div>
            </div>
        )
    }
});
var Flight = React.createClass({
    render:function () {
        var flightData = this.props.flightdata.itineraries[0].outbound.flights;
        var outboundFlightData = this.props.flightdata.itineraries[0].outbound.flights;
        var inboundFlightData = (this.props.flightdata.itineraries[0].inbound)? this.props.flightdata.itineraries[0].inbound.flights:null;
        var duration = this.props.flightdata.itineraries[0].outbound.duration;
        var inboundDuration = (this.props.flightdata.itineraries[0].inbound) ? this.props.flightdata.itineraries[0].inbound.duration : null;
        var totalPrice = this.props.flightdata.fare.total_price;
        var id = "info" + this.props.index;
        var target = "#info" + this.props.index;
        return (<div id="flightInfo">
            <FlightHeading target={target} duration = {duration} flightData={flightData} inboundDuration={inboundDuration} outboundFlightData={outboundFlightData} inboundFlightData={inboundFlightData}
                           totalPrice={totalPrice}></FlightHeading>
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
