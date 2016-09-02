import React from 'react';
import FlightsStore from '../stores/FlightsStore.jsx';
import FlightsSearchForm from '../components/flightsSearchForm.jsx';
import FlightsList from '../components/flightsList.jsx';
import * as FlightsActions from '../actions/FlightsActions.jsx';
import * as HotelsActions from '../actions/HotelsActions.jsx';

var FLightsSearchPanel = React.createClass({
    getInitialState:function() {

        return {
            flights: FlightsStore.getAllFlights()
        }
    },

    // update search result
    componentWillMount: function() {
        FlightsStore.on("change", this.getFlights);
    },

    componentWillUnmount: function() {
        FlightsStore.removeListener("change", this.getFlights);
    },

    getFlights: function() {
        this.setState({
            flights: FlightsStore.getAllFlights(),
        });
    },
    reloadFlights: function(jsonRequest) {
        FlightsActions.reloadFlights(jsonRequest);
    },
    reloadLocations: function(locationKey) {
        HotelsActions.reloadLocations(locationKey);
    },

    render:function () {
        var renderComponent;
        if(!this.state.flights) {
            renderComponent = <FlightsSearchForm reloadFlights={this.reloadFlights} updateLocations = {this.reloadLocations}></FlightsSearchForm>
        }
        else {
            renderComponent = <FlightsList flightsData={this.state.flights}></FlightsList>
        }
        return(
            <div className="flightsSearchPanel">
                {renderComponent}
            </div>
        );
    }
});
export default FLightsSearchPanel;