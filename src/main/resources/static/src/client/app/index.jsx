import React from 'react';
import {render} from 'react-dom';
import DisplayFlights from './FlightsDisplay.jsx';
import SearchForm from './searchForm.jsx';

class App extends React.Component {
  render () {
    return (
      <div>
        <h1> Welcome to Synerzip Travel-time </h1>
        <SearchForm></SearchForm>
      </div>
    );
  }
}

render(<App/>, document.getElementById('app'));