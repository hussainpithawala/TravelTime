import React from 'react';
import {render} from 'react-dom';
import HotelSearchPanel from './pages/hotelSearchPanel.jsx';

class App extends React.Component {
    render () {
        return (
            <div>
                <div>
                    <h1 id="logo"> Synerzip Travel-time </h1>
                </div>
                <div id="tabBar">
                    <ul className="nav nav-tabs">
                        <li className="dropdown">
                            <a className="dropdown-toggle glyphicon glyphicon-home" data-toggle="dropdown" href="#">
                                {/*<span className="caret"></span>*/}
                            </a>
                            <ul className="dropdown-menu">
                                <li><a href="#">Submenu 1-1</a></li>
                                <li><a href="#">Submenu 1-2</a></li>
                                <li><a href="#">Submenu 1-3</a></li>
                            </ul>
                        </li>
                        <li className="active" ><a href="#HOTEL" data-toggle="tab">HOTEL</a></li>
                        <li><a href="#FLIGHTS" data-toggle="tab">FLIGHTS</a></li>
                    </ul>
                    <div className="tab-content">
                        <div className="tab-pane active" id="HOTEL">
                            <section className="panel" id="scroll-tab-1">
                                <HotelSearchPanel></HotelSearchPanel>
                            </section>
                        </div>
                        <div className="tab-pane" id="FLIGHTS">
                            <section className="panel" id="scroll-tab-2">
                                <div className="row">
                                    FLIGHTS
                                </div>
                            </section>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

render(<App/>, document.getElementById('app'));
