import React from 'react';

import SearchForm from './searchForm.jsx';
import SearchResult from './searchResult.jsx';
import * as HotelsActions from './actions/HotelsActions.jsx';
import HotelsStore from './stores/HotelsStore.jsx';

var SearchPanel = React.createClass({
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

  render: function () {
    if(this.state.hotels) {
      var SearchResultOption = <SearchResult searchResult={this.state.hotels}></SearchResult>
    } else {
      var SearchResultOption = <div className="circular"></div>
    }
    return(
      <div className="mdl-grid">
        <SearchForm updateSearchResult = {this.reloadHotels}></SearchForm>
        {SearchResultOption}
      </div>
    );
  }
});
export default SearchPanel;
