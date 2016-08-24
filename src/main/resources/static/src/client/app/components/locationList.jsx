import React from 'react';

import LocationsStore from '../stores/LocationsStore.jsx';

var LocationDataList = React.createClass({
  getInitialState: function() {
    return {
      locations: LocationsStore.getAllLocations()
    };
  },

  componentWillMount: function() {
    LocationsStore.on("change", this.getLocations);
  },

  componentWillUnmount: function() {
    LocationsStore.removeListener("change", this.getLocations);
  },

  getLocations: function() {
    console.log('Location event fired..');
    this.setState({
      locations: LocationsStore.getAllLocations(),
    });
  },

  getOptions : function () {
  	console.log('getting locations options..');
    var options = [];
    for (let location in this.state.locations) {	
   	  options.push(<option key={this.state.locations[location].value} value={this.state.locations[location].value}>
   	  				  {this.state.locations[location].label}
   	  			   </option>);
	}
    return options;
  },
  render: function () {
    return (
      <datalist id={this.props.id}>
        {this.getOptions()}
      </datalist>
    );
  }
});
export default LocationDataList;
