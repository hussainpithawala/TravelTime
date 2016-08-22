import React from 'react';
import {render} from 'react-dom';
import HotelSearchPanel from './pages/hotelSearchPanel.jsx';

class App extends React.Component {
    render () {
        return (
            <div>
                <h4 id="logo"> Welcome to Synerzip Travel-time </h4>
                <div className="mdl-tabs mdl-js-tabs mdl-js-ripple-effect">
                    <div className="mdl-tabs__tab-bar" id="tabBar">
                        <a href="#HOTEL" className="mdl-tabs__tab is-active">HOTEL</a>
                        <a href="#FLIGHTS" className="mdl-tabs__tab">FLIGHTS</a>
                    </div>
                    <div className="mdl-tabs__panel is-active" id="HOTEL">
                        <section className="mdl-layout__tab-panel is-active" id="scroll-tab-1">
                            <HotelSearchPanel></HotelSearchPanel>
                        </section>
                    </div>
                    <div className="mdl-tabs__panel" id="FLIGHTS">
                        <section className="mdl-layout__tab-panel is-active" id="scroll-tab-2">
                            <div className="mdl-grid">
                                FLIGHTS
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        );
    }
}

render(<App/>, document.getElementById('app'));