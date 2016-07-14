import React from 'react';

var FlightCompanyLogo = React.createClass({
  render: function() {
    return (<th colSpan="2">{this.props.company}</th>);
  }
});

var Flights = React.createClass({
  render: function() {
    return (
        <td>
          <div>
            {this.props.dep}
          </div>
        </td>
    );
  }
});

var FlightsList = React.createClass({
  render: function() {
    var flightRows = [];
    this.props.results.forEach(function (itineraries){
      var flights = [];
      itineraries.itineraries.forEach(function(itinerary){
        itinerary.outbound.flights.forEach(function(flight){
          flights.push(<Flights dep={flight.origin.airport} />);
        });
      });
      flightRows.push(
        <tr>
          <FlightCompanyLogo company = {itineraries.itineraries[0].outbound.flights[0].marketing_airline}/>
          {flights}
        </tr>
      );
    }.bind(this));
    return (
      <table>
        <tbody frameBorder="1">{flightRows}</tbody>
      </table>
    );
  }
});

var FlightsDisplay = React.createClass({
  render: function() {
    return (
      <div>
        <FlightsList
          results={this.props.results}
        />
      </div>
    );
  }
});

export default FlightsDisplay;
