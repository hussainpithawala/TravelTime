import React from 'react';
import ReactDOM from 'react-dom';
import MapInfoWindow from './mapInfoWindow.jsx'

class HotelsMap extends React.Component {

  constructor() {
    super();
    this.state = { zoom: 12 };
  }

  static propTypes() {
  	initialCenter: React.PropTypes.objectOf(React.PropTypes.number).isRequired
  }

	render() {
    return (
    	<div className="HotelsMap">
      	<div className='HotelsMap-canvas' ref="mapCanvas"></div>
    	</div>
    );
  }

  componentDidMount() {
    // create the map, marker after the component has
    // been rendered because we need to manipulate the DOM for Google map
    this.map = this.createMap()
    this.createMarkers()
    // TODO : Add listners here
  }

  // clean up event listeners when component unmounts
  componentDidUnMount() {
    // TODO : Removed listeners here created inside componentDidMount()
  }

  createMap() {
    let mapOptions = {
      zoom: this.state.zoom,
      center: this.mapCenter()
    }
    return new google.maps.Map(this.refs.mapCanvas, mapOptions)
  }

  mapCenter() {
    return new google.maps.LatLng(
      this.props.initialCenter.lat,
      this.props.initialCenter.lng
    )
  }

  createMarkers() {
  	var hotelsList =  this.props.searchResult;
    var markerList = [];
    var infoWindowList = [];
  	for (let i = 0; i < hotelsList.length; i++) {
  		var hotel = hotelsList[i];
  		var label = hotel.total_price.amount;
  	  markerList[i] = new google.maps.Marker({
      	position: { lat:hotel.location.latitude, lng: hotel.location.longitude },
      	map: this.map,
      	title: hotel.property_name,
      	label: label
      });
      infoWindowList[i] = this.createInfoWindow(hotel);
      markerList[i].addListener('click', function() {
        infoWindowList[i].open(this.map, markerList[i]);
      });
  	}
    return markerList;
  }

  createInfoWindow(hotelInfo) {
    var div = document.createElement('div');
    ReactDOM.render(<MapInfoWindow hotelInfo={hotelInfo}/>, div );
    return new google.maps.InfoWindow({
      content: div
    })
  }
}

export default HotelsMap;


