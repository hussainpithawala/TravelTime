import React from 'react';
import FlightsStore from '../stores/FlightsStore.jsx';

var FLightsSearchPanel = React.createClass({
    getInitialState:function() {
        return {
            flights:FlightsStore.getAllFlights()
        }
    },

    render:function () {
        var renderComponent;
        if(!this.state.flights) {
            renderComponent = <h1> Flights search Form</h1>
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