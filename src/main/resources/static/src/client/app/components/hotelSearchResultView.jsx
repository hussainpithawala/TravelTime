import React from 'react';

import HotelsStore from '../stores/HotelsStore.jsx';
import HotelSearchResult from '../components/hotelsList.jsx';

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
		if (hotelsList) {
			if (this.state.defaultView === 'MAPVIEW') {
				hotelResultViewType = <div> Loading map view... </div>
			} else if(this.state.defaultView === 'LISTVIEW') {
				hotelResultViewType = <HotelSearchResult searchResult={hotelsList}></HotelSearchResult>
			} else {
				console.log('Something went wrong!! No view registered.');
			}
		} else {
			hotelResultViewType = <div> <h1> No results found </h1> </div>;
		}
		return (
			<div className="row">
				<div className="row">
    				<span>Results</span>
    				<button className="btn btn-primary pull-right" onClick= {this.props.onClick}>
    					Back
    				</button>
				</div>
				<div className="row">
					<span>
    					<div className="btn-group pull-right" role="group" aria-label="...">
  							<button type="button" className="btn btn-default" name="LISTVIEW" onClick={this.onViewClick}>
    							<span className="glyphicon glyphicon-th-list" aria-hidden="true"></span> List
  							</button>
  							<button type="button" className="btn btn-default" name="MAPVIEW" onClick={this.onViewClick}>
   								<span className="glyphicon glyphicon-globe" aria-hidden="true"></span> Map
							</button>
						</div>
    				</span>
				</div>
				<div className="row">
					{hotelResultViewType}
				</div>
			</div>	
		);
	}
});
export default hotelSearchResultView;