import React from 'react';
import LocationsDataList from '../components/locationList.jsx';

var NumberSelector = React.createClass({
    getInitialState: function() {
        //this.getOptions = this.getOptions.bind(this);
        return {
            value:parseInt(this.props.value),
            to:parseInt(this.props.to),
            from:parseInt(this.props.from)
        };
    },
    decrement: function() {
        if (this.state.value > this.state.from)
        {
            this.setState({value: this.state.value - 1});
            this.props.onChange(this.state.value);
        }
    },
    increment: function() {
        if (this.state.value < this.state.to)
        {
            this.setState({value: this.state.value + 1});
            this.props.onChange(this.state.value);
        }
    },
    render: function () {
        return (
            <div className="segmented_controls form-control col-xs-4">
                <a className="col-sm-4" onClick={this.decrement} href="javascript:void(0);">
                    -
                </a>
                <span className="adultCount col-sm-4">
                    {this.state.value}
                </span>
                <a className="col-sm-4"  onClick={this.increment} href="javascript:void(0);">
                    +
                </a>
            </div>
        );
    }
});

var TextInput = React.createClass({
    // onChange event handling
    handleChange: function(e) {
        this.props.onChange(e.target.value);
        // var isValidField = this.isValid(e.target);
    },
    // validation function
    isValid: function(inputValue) {
        // check required fields
        if ((inputValue.getAttribute('required') != null) && (inputValue.value = '')) {
            inputValue.classList.add('error'); // add error class
            inputValue.nextSibling.textContent = this.props.messageRequired; // Show error message
            return false;
        } else {
            inputValue.classList.remove('error'); // remove error class
            inputValue.nextSibling.textContent = '';
        }
        return true;
    },
    componentDidMount: function(){
        if (this.props.onComponentMounted) {
            this.props.onComponentMounted(this);
        }
    },
    render: function() {
        var inputField;
        if (this.props.type == 'text' && this.props.list) {
            inputField = <div>
                <label htmlFor={this.props.name}>{this.props.name}</label>
                <input className="form-control" value={this.props.value} name={this.props.name}
                       placeholder={this.props.name} ref={this.props.name}
                       required = {this.props.isrequired} onChange = {this.handleChange}
                       id={this.props.name} list={this.props.list}/>
            </div>
        } else if (this.props.type == 'text') {
            inputField = <div>
                <label htmlFor={this.props.name}>{this.props.name}</label>
                <input className="form-control" value={this.props.value} name={this.props.name}
                       placeholder={this.props.name} ref={this.props.name}
                       required = {this.props.isrequired} onChange = {this.handleChange}
                       id={this.props.name} list={this.props.list}/>
            </div>
        } else if(this.props.type == 'date' ) {
            inputField = <div>
                <label htmlFor={this.props.name}>{this.props.name}</label>
                <input type="date" className="form-control" value={this.props.value} name={this.props.name} placeholder={this.props.name}
                       ref={this.props.name} required = {this.props.isrequired} onChange = {this.handleChange}
                       id={this.props.name} data-type="date" min={this.props.min}/>
                </div>

        }
        return (
            <div className="col-sm-6">
                {inputField}
                <span className="error"></span>
            </div>
        )
    }
});

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
