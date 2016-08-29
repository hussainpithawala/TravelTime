import React from 'react';
import FlightsStore from '../stores/FlightsStore.jsx';
import FlightsSearchForm from '../components/flightsSearchForm.jsx';

var FLightsSearchPanel = React.createClass({
    getInitialState:function() {
        return {
            flights:FlightsStore.getAllFlights()
        }
    },

    render:function () {
        var renderComponent;
        if(!this.state.flights) {
            renderComponent = <FlightsSearchForm></FlightsSearchForm>
        }
        else {
            renderComponent = <h1> Flights Result Display</h1>
        }
        return(
            <div>
                {renderComponent}
            </div>
        );
    }
});
export default FLightsSearchPanel;