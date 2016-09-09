import React from 'react';

import HotelSearchForm from '../components/hotelSearchForm.jsx';
import HotelSearchResultView from '../components/hotelSearchResultView.jsx';
import * as HotelsActions from '../actions/HotelsActions.jsx';
import HotelsStore from '../stores/HotelsStore.jsx';

var HotelSearchPanel = React.createClass({
  getInitialState: function() {
    return {
      defualtView: 'FORMVIEW',
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
      defualtView: 'RESULTSVIEW'
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
      defualtView: 'FORMVIEW'
    });
  },

  getHotelsResult: function() {
    return this.state.hotels;
  },

  render: function () {
    var renderComponent;
    if(this.state.defualtView === 'RESULTSVIEW') {
      console.log('loading result view...');
          renderComponent = <HotelSearchResultView onClick= {this.backToHotelsSearch}
                                                   getHotelsResult={this.getHotelsResult}></HotelSearchResultView>
    } else {
          renderComponent = <HotelSearchForm updateSearchResult = {this.reloadHotels}
                                             updateLocations = {this.reloadLocations}></HotelSearchForm>
    }

    return (
        <div>
          {renderComponent}
        </div>
    );
  }
});
export default HotelSearchPanel;
