import React from 'react';

var ItineraryDetails = React.createClass({
    render: function () {
        return (
            <div id="itineraryDetails">
                <p>
                    itinerary details(coming soon).
                </p>
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
            component = <ItineraryDetails></ItineraryDetails>
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
    render:function () {
        return (
            <div className="row" data-toggle="collapse" data-target={this.props.target}>
                <div className="col-xs-1">{this.props.flightData.operating_airline}</div>
                <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    {this.props.flightData.departs_at}
                    <br/>
                    <span>{this.props.flightData.origin.airport}</span>
                </div>
                <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">
                    {this.props.flightData.arrives_at}
                    <br/>
                    <span>{this.props.flightData.destination.airport}</span>
                </div>
                <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">DURATION</div>
                <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">{this.props.totalPrice} USD</div>
                <div className="col-xs-1 col-sm-1 col-md-1 col-lg-1">
                    <span id="details">Show Details</span>
                </div>
            </div>
        )
    }
});
var Flight = React.createClass({
    render:function () {
        var flightData = this.props.flightdata.itineraries[0].outbound.flights[0];
        var totalPrice = this.props.flightdata.fare.total_price;
        var id = "info" + this.props.index;
        var target = "#info" + this.props.index;
        return (<div id="flightInfo">
            <FlightHeading target={target} flightData={flightData} totalPrice={totalPrice}></FlightHeading>
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
            <div id="flightsContent">
                <ListHeading></ListHeading>
                <List data={this.props.flightsData.results}></List>
            </div>
        </div>)
    }
});

export default FlightsList;