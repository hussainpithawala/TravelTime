import React from 'react';

import HotelSearchForm from '../components/hotelSearchForm.jsx';
import HotelSearchResultView from '../components/hotelSearchResultView.jsx';
import * as HotelsActions from '../actions/HotelsActions.jsx';
import HotelsStore from '../stores/HotelsStore.jsx';

var HotelSearchPanel = React.createClass({
  getInitialState: function() {
    return {
      defaultView: this.props.defaultView,
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
      defaultView: 'RESULTSVIEW'
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
      defaultView: 'FORMVIEW'
    });
  },

  getHotelsResult: function() {
    return this.state.hotels;
  },

  componentWillReceiveProps: function(nextProps) {
    this.setState({
      defaultView: this.props.defaultView
    });
  },

  render: function () {
    var renderComponent;
    if(this.state.defaultView === 'RESULTSVIEW') {
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
