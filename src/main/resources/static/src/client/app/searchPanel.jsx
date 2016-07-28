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
    if(this.state.searchResult) {
      var SearchResultOption = <SearchResult searchResult={this.state.searchResult}></SearchResult>
    } else {
      var SearchResultOption = <div className="circular"></div>
    }
    return(
      <div className="mdl-grid">
        <SearchForm updateSearchResult = {this.updateSearchResult}></SearchForm>
        {SearchResultOption}
      </div>
    );
  }
});
export default SearchPanel;
