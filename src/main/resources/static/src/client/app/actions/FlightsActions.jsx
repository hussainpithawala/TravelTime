import dispatcher from '../dispatchers/Dispatcher.jsx';
import axios from 'axios';

export function reloadFlights(requestJSON) {
    console.log('reloading...', requestJSON);
    $.getJSON( "src/client/app/components/searchFlightResponse.json", function( data ) {
        dispatcher.dispatch({type: "RECEIVE_FLIGHTS", flights: data});
    }.bind(this));
}