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
  	  markerList[i] = new google.maps.Marker({
      	position: { lat:hotel.location.latitude, lng: hotel.location.longitude },
      	map: this.map,
      	title: hotel.property_name,
        icon : this.markerSymbol(hotel.total_price.amount)
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

  markerSymbol(labelPrice) {
    // Decoded svg image using https://goo.gl/1TokNv
    var image = 
      'data:image/svg+xml,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org'+
      '%2F2000%2Fsvg%22%20width%3D%2250%22%20height%3D%2250%22%20viewBox'+
      '%3D%220%200%2050%2050%22%3E%3Cpath%20fill%3D%22%230083FF%22%20stroke'+
      '%3D%22%23ccc%22%20stroke-width%3D%22.5%22%20d%3D%22M34.305%2016.234c0'+
      '%208.83-15.148%2019.158-15.148%2019.158S3.507%2025.065%203.507%2016.1c0-8.505'+
      '%206.894-14.304%2015.4-14.304%208.504%200%2015.398%205.933%2015.398%2014.438z'+
      '%22%2F%3E%3Ctext%20transform%3D%22translate(19%2018.5)%22%20fill%3D%22%23fff'+
      '%22%20style%3D%22font-family%3A%20Arial%2C%20sans-serif%3Bfont-weight%3Abold'+
      '%3Btext-align%3Acenter%3B%22%20font-size%3D%229%22%20text-anchor%3D%22middle'+
      '%22%3E%24'+labelPrice+'%3C%2Ftext%3E%3C%2Fsvg%3E'
      return image;
    // return {
    //     path: 'M 0,0 C -2,-20 -10,-22 -10,-30 A 10,10 0 1,1 10,-30 C 10,-22 2,-20 0,0 z',
    //     fillColor: 'green',
    //     fillOpacity: 0.8,
    //     strokeColor: 'gold',
    //     strokeWeight: 2,
    //     scale: 2
    // };
}
}

export default HotelsMap;


