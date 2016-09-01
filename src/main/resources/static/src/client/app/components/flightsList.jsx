import React from 'react';

var Flight = React.createClass({
    render:function () {
        var flightData = this.props.flightdata.itineraries[0].outbound.flights[0];
        var totalPrice = this.props.flightdata.fare.total_price;
        var id = "info" + this.props.index;
        var target = "#info" + this.props.index;
        return (<div id="flightInfo">
            <div className="row" data-toggle="collapse" data-target={target}>
                <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">{flightData.departs_at}</div>
                <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">{flightData.arrives_at}</div>
                <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">DURATION</div>
                <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">{totalPrice} USD</div>
                <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                    <span id="details">Show Details..</span>
                </div>
            </div>
            <div id={id} className="collapse flightDetails">
                <p>Coming Soon.</p>
            </div>
        </div>)
    }
});

var List = React.createClass({
    render:function () {
        return(
            <div className="flightList">
                {this.props.data.map(function(flightData, index) {
                    console.log(flightData);
                    return (<Flight key={flightData.itineraries[0].outbound.flights[0].flight_number} index={index} flightdata={flightData}/>)
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
                    <div className="col-xs-3 col-sm-3 col-md-3 col-lg-3">DEPARTURE</div>
                    <div className="col-xs-3 col-sm-2 col-md-3 col-lg-3">ARRIVAL</div>
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">DURATION</div>
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2">PRICE</div>
                    <div className="col-xs-2 col-sm-2 col-md-2 col-lg-2"></div>
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
                <List data={this.props.flightsData[0].results}></List>
            </div>
        </div>)
    }
});

export default FlightsList;