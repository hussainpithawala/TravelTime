import React from 'react';
import {render} from 'react-dom';
import DisplayFlights from './FlightsDisplay.jsx';
import SearchForm from './searchForm.jsx';
import SearchResult from './searchResult.jsx';

class App extends React.Component {
    render () {
        return (
            <div>
                <h1> Welcome to Synerzip Travel-time </h1>
                <div className="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
                    <div className="mdl-tabs__tab-bar" id="tabBar">
                        <a href="#SHOP" className="mdl-tabs__tab is-active">SHOP</a>
                        <a href="#lannisters-panel" className="mdl-tabs__tab">Lannisters</a>
                        <a href="#targaryens-panel" className="mdl-tabs__tab">Targaryens</a>
                    </div>
                    <div className="mdl-tabs__panel is-active" id="SHOP">
                        <section className="mdl-layout__tab-panel is-active" id="scroll-tab-1">
                            <div className="mdl-grid">
                                <SearchForm></SearchForm>
                                <SearchResult></SearchResult>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        );
    }
}

render(<App/>, document.getElementById('app'));