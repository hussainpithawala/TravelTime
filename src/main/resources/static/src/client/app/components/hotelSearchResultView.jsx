import React from 'react';

import HotelsStore from '../stores/HotelsStore.jsx';
import HotelSearchResult from '../components/hotelsList.jsx';
import MapPage from '../components/hotelsMap.jsx';

var hotelSearchResultView = React.createClass({
	getInitialState: function() {
		return {
			defaultView: 'LISTVIEW'
		}
	},
	onViewClick: function(event) {
		if (event.target.name === 'MAPVIEW') {
			this.setState({
				defaultView: 'MAPVIEW'
			});
		} else {
			this.setState({
				defaultView: 'LISTVIEW'
			});
		}
	},
	render: function(){
		var hotelResultViewType = '';
		var hotelsList = this.props.getHotelsResult();
		var hotelInfoStyle = {height: 500};
		if (hotelsList) {
			if (this.state.defaultView === 'MAPVIEW') {
				var initialCenter = {lng: hotelsList[0].location.longitude, lat:hotelsList[0].location.latitude};
				hotelResultViewType = <div className="col-md-12" style={hotelInfoStyle}> 
																<MapPage initialCenter={initialCenter} searchResult={hotelsList}></MapPage>
															</div>;
			} else if(this.state.defaultView === 'LISTVIEW') {
				hotelResultViewType = <HotelSearchResult searchResult={hotelsList}></HotelSearchResult>;
			} else {
				console.log('Something went wrong!! No view registered.');
			}
		} else {
			hotelResultViewType = <div> <h1> No results found </h1> </div>;
		}
		return (
			<form id = "flightsearch">
				<div className="row col-xs-12 col-centered">
					<div className="col-md-6">
						<span className="flow-text" id="mainText">Hotel Results </span>
					</div>
					<div className="col-md-6">
						<button id = "backButton" className="btn btn-primary pull-right" onClick= {this.props.onClick}>
							Back
						</button>
					</div>
					<div className = "row col-xs-12 col-centered">
						<div id = "groupButton" className="btn-group pull-right" role="group" aria-label="...">
							<button type="button" className="btn btn-default" name="LISTVIEW"
									onClick={this.onViewClick}>
								<span className="glyphicon glyphicon-th-list" aria-hidden="true"></span> List
							</button>
							<button type="button" className="btn btn-default" name="MAPVIEW"
									onClick={this.onViewClick}>
								<span className="glyphicon glyphicon-globe" aria-hidden="true"></span> Map
							</button>
						</div>
						<span id="note">LOWEST AVAILABLE NIGHTLY RATE PER ROOM</span>
					</div>
					<div className = "row col-xs-12 col-centered">
						{hotelResultViewType}
					</div>
				</div>
			</form>
		);
	}
});
export default hotelSearchResultView;
