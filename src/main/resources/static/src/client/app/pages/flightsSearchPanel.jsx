import React from 'react';
import FlightsStore from '../stores/FlightsStore.jsx';
import FlightsSearchForm from '../components/flightsSearchForm.jsx';
import FlightsList from '../components/flightsList.jsx';
import * as FlightsActions from '../actions/FlightsActions.jsx';

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
    reloadFlights: function(e) {
        FlightsActions.reloadFlights({data:"xyz"});
    },

    render:function () {
        var renderComponent;
        if(!this.state.flights) {
            renderComponent = <FlightsSearchForm reloadFlights={this.reloadFlights}></FlightsSearchForm>
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
