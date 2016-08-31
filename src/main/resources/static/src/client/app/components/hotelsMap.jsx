import React from 'react';

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
  	for (let i = 0; i < hotelsList.length; i++) {
  		var hotel = hotelsList[i];
  		var label = hotel.total_price.amount;
  	  new google.maps.Marker({
      	position: { lat:hotel.location.latitude, lng: hotel.location.longitude },
      	map: this.map,
      	title: hotel.property_name,
      	label: label
      });
  	}
    return null;
  }
}

export default HotelsMap;


