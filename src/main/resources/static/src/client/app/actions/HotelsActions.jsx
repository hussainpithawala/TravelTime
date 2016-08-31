import dispatcher from '../dispatchers/Dispatcher.jsx';
import axios from 'axios';

export function reloadHotels(requestJSON) {
  console.log('reloading...', requestJSON);
  axios({
    method: 'post',
    url: '/rest/hotelSearchByAirportCode',
    headers: {
      'Content-Type': 'application/json'
    },
    data: JSON.stringify(requestJSON)
  })
  .then(function (response) {
    console.log("got the data!", response);
    dispatcher.dispatch({type: "RECEIVE_HOTELS", hotels: response.data.results});
  })
  .catch(function (error) {
    console.log(error);
  });
};

export function reloadLocations(key) {
  console.log('reloading locations...', key);
  axios({
    method: 'post',
    url: 'rest/airportAutocomplete',
    headers: {
      'Content-Type': 'application/json'
    },
    data: {
      term:key
    }
  })
  .then(function (response) {
    console.log("got the location list!");
    dispatcher.dispatch({type: "RECEIVE_LOCATIONS", locations: response.data});
  })
  .catch(function (error) {
    console.log(error);
  });
};
