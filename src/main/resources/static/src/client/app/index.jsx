import React from 'react';
import {render} from 'react-dom';
import HotelSearchPanel from './pages/hotelSearchPanel.jsx';
import FlightsSearchPanel from './pages/flightsSearchPanel.jsx';
import GoogleMaps from './components/googleMap.jsx';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            indexView: 'FORMVIEW'
        }
    }

    handleClick() {
        this.setState({
            indexView : 'FORMVIEW'
        });
    }

    componentDidMount() {
      GoogleMaps.load();
    };

    render () {
        return (
            <div id="mainPage">
                <div>
                    <h2 id="logo"> Synerzip Travel-time </h2>
                </div>
                <div className="container-fluid" id="content">
                    <div id="tabBar">
                        <ul className="nav nav-tabs">
                            <li className="active" >
                                <a className="glyphicon glyphicon-home" data-toggle="tab" href="#HOTEL"
                                   onClick={this.handleClick.bind(this)}>
                                </a>
                            </li>
                            <li><a href="#HOTEL" data-toggle="tab">HOTEL</a></li>
                            <li><a href="#FLIGHTS" data-toggle="tab">FLIGHTS</a></li>
                        </ul>
                        <div className="tab-content">
                            <div className="tab-pane active" id="HOTEL">
                                <section className="panel" id="scroll-tab-1">
                                    <HotelSearchPanel defaultView = {this.state.indexView}></HotelSearchPanel>
                                </section>
                            </div>
                            <div className="tab-pane" id="FLIGHTS">
                                <section className="panel" id="scroll-tab-2">
                                    <FlightsSearchPanel defaultView = {this.state.indexView}></FlightsSearchPanel>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

render(<App/>, document.getElementById('app'));
