import React from 'react';
import LocationsDataList from '../components/locationList.jsx';
import NumberSelector from '../helpercomponents/numberSelector.jsx';
import TextInput from '../helpercomponents/textInput.jsx';

var FlightsSearchForm = React.createClass({
    // get initial state event
    getInitialState: function() {
        return {
            from:'',
            to:'',
            dep:'',
            returnDate:'',
            selectedOption: 'one way',
            adult:1,
            child:0,
            infant:0,
            serverMessage:'',
            Fields:[]
        };
    },
    handleSearch: function (e) {
        e.preventDefault();
        var requestJson = {
            "origin": this.state.from,
            "destination":this.state.to,
            "departure_date": this.state.dep,
            "return_date":this.state.return_date,
            "adults":this.state.adult,
            "children":this.state.child,
            "infants":this.state.infant
        };
        this.props.reloadFlights(requestJson);
    },

    handleOptionChange: function (changeEvent) {
        this.setState({
            selectedOption: changeEvent.target.value
        });
    },
    onChangeChild:  function (childCount) {
        this.setState({
            child: childCount
        });
    },
    onChangeAdult:  function (adultCount) {
        this.setState({
            adult: adultCount
        });
    },
    onChangeInfant:  function (infantCount) {
        this.setState({
            infant: infantCount
        });
    },
    onChangeFrom: function (location) {
        var me = this;
        this.props.updateLocations(location);
        this.setState({
            from: location
        });
        console.log("changed location");
    },
    onChangeTo: function (location) {
        this.setState({
            to: location
        });
        console.log("changed location");
    },
    onChangeDepartureDate: function (date) {
        this.setState({
            dep: date
        });
        if (new Date(date) > new Date(this.state.returnDate)) {
            this.setState({
                returnDate: date
            });
        }
    },
    onChangeReturnDate:function (date) {
        this.setState({
            returnDate: date
        });
    },
    render: function() {
        return (
            <form id="flightsearch" onSubmit={this.handleSearch} className="row col-sm-12 ">
                <div className="row col-sm-12 col-centered">
                    <h1>Book Flight Tickets</h1>
                </div>
                <div className="row col-sm-12 col-centered">
                    <label className="col-sm-3 col-xs-12 col-sm-3 col-sm-3">
                        <input type="radio" name="tripType" value="one way"
                               checked={this.state.selectedOption === 'one way'}
                               onChange={this.handleOptionChange}/>{'  '}ONE WAY
                    </label>
                    <label className="col-sm-3 col-xs-12 col-sm-3 col-sm-3">
                        <input type="radio" name="tripType" value="round trip"
                               checked={this.state.selectedOption === 'round trip'}
                               onChange={this.handleOptionChange}/> {'  '}ROUND TRIP
                    </label>
                </div>
                <div className="row col-sm-12 col-centered">
                    <TextInput type="text" value={this.state.from}  name={'From'}
                               htmlFor={'From'} isRequired={true} onChange={this.onChangeFrom}
                               onComponentMounted={this.register} messageRequired={'Location Required'}
                               list={'locations'}
                    />
                    <LocationsDataList id="From"/>
                    <TextInput type="text" value={this.state.to}  name={'To'}
                               htmlFor={'to'} isRequired={true} onChange={this.onChangeTo}
                               onComponentMounted={this.register} messageRequired={'Location Required'}
                               list={'locations'}
                    />
                    <LocationsDataList id="To"/>
                </div>
                <div className="row col-sm-12 col-centered">
                    <TextInput type="date" value={this.state.dep} label={'Departure'} name={'Departure'}
                               htmlFor={'Departure'} isRequired={true} onChange={this.onChangeDepartureDate}
                               onComponentMounted={this.register} messageRequired={'Departure Date required'}
                    />
                    <TextInput type="date" value={this.state.returnDate} label={'Return'} name={'Return'}
                               htmlFor={'Return'} isRequired={false} onChange={this.onChangeReturnDate}
                               onComponentMounted={this.register}
                    />
                </div>
                <div className="row col-xs-12 col-centered ">
                    <div className="col-xs-3">
                        <label htmlFor="adult">
                            ADULT
                        </label>
                        <NumberSelector from="1" to="14" value="1" id="adult" onChange={this.onChangeAdult}/>
                    </div>
                    <div className="col-xs-3">
                        <label htmlFor="child">
                            CHILD
                        </label>
                        <NumberSelector from="0" to="9" value="0" id="child" onChange={this.onChangeChild}/>
                    </div>
                    <div className="col-xs-3">
                        <label htmlFor="infant">
                            INFANT
                        </label>
                        <NumberSelector from="0" to="9" value="0" id="infant" onChange={this.onChangeInfant}/>
                    </div>
                </div>
                <div className="row col-xs-12 col-centered">
                    <div className="col-sm-3">
                        <button type="submit" className="btn btn-primary btn-block" id="submit">Search</button>
                    </div>
                </div>
            </form>
        );
    }
});
export default FlightsSearchForm;
