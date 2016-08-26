import React from 'react';

import HotelSearchForm from '../components/hotelSearchForm.jsx';
import HotelSearchResult from '../components/hotelsList.jsx';
import * as HotelsActions from '../actions/HotelsActions.jsx';
import HotelsStore from '../stores/HotelsStore.jsx';

var HotelSearchPanel = React.createClass({
  getInitialState: function() {
    return {
      hotels: HotelsStore.getAllHotels()
    };
  },
  // update search result

  componentWillMount: function() {
    HotelsStore.on("change", this.getHotels);
  },

  componentWillUnmount: function() {
    HotelsStore.removeListener("change", this.getHotels);
  },

  getHotels: function() {
    this.setState({
      hotels: HotelsStore.getAllHotels(),
    });
  },

  reloadHotels: function(requestJSON) {
    HotelsActions.reloadHotels(requestJSON);
  },

  reloadLocations: function(locationKey) {
    HotelsActions.reloadLocations(locationKey);
  },
  
  backToHotelsSearch() { 
    this.setState({
      hotels: ''
    });
  }, 

  render: function () {
    if(this.state.hotels) {
      var SearchResultOption = <HotelSearchResult searchResult={this.state.hotels}></HotelSearchResult>
      return(
        <div className="row">
          <div className="col-sm-4">
            <button className="btn btn-primary" onClick= {this.backToHotelsSearch}>Back</button>
          </div>
          {SearchResultOption}
        </div>
      );
    } else {
      return (
        <div className="row">
          <HotelSearchForm updateSearchResult = {this.reloadHotels} updateLocations = {this.reloadLocations}></HotelSearchForm>
        </div>
      );
    }
  }
});
export default HotelSearchPanel;
