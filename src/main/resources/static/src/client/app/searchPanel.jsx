import React from 'react';

import SearchForm from './searchForm.jsx';
import SearchResult from './searchResult.jsx';

var SearchPanel = React.createClass({
  getInitialState: function() {
    return {
      searchResult: ''
    };
  },
  // update search result
  updateSearchResult: function(result) {
    this.setState({
      searchResult: result
    });
  },

  render: function () {
    return(
      <div className="mdl-grid">
        <SearchForm updateSearchResult = {this.updateSearchResult}></SearchForm>
        <SearchResult searchResult={this.state.searchResult}></SearchResult>
      </div>
    );
  }
});
export default SearchPanel;