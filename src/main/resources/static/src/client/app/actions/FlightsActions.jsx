import dispatcher from '../dispatchers/Dispatcher.jsx';
import axios from 'axios';

export function reloadFlights(requestJSON) {
    console.log('reloading...', requestJSON);
    axios({
        method: 'post',
        url: '/rest/searchFlights',
        headers: {
            'Content-Type': 'application/json'
        },
        data: JSON.stringify(requestJSON)
    })
        .then(function (response) {
            console.log("got the data!", response);
            dispatcher.dispatch({type: "RECEIVE_FLIGHTS", flights: response.data});
            dispatcher.dispatch({type: "RECEIVE_FLIGHTS", flights: response.data});
        })
        .catch(function (error) {
            console.log(error);
        });
}