import React from 'react';
import Collapsible from 'react-collapsible';

var HotelDetails = React.createClass({
render: function () {
    var hotelDetails = this.props.details;
    return (<div id="hotelInfo" className="mdl-grid">
        <div className="mdl-cell mdl-cell--4-col">
            <h6> <b>Address: </b> </h6>
            <p> {this.props.details.address.line1} {hotelDetails.address.city}</p>
        </div>
        <div className="mdl-cell mdl-cell--8-col">
            <h6> <b>Contact: </b> </h6>
            <p> {this.props.details.contacts[0].detail}</p>
        </div>
    </div>)}
});

var Room = React.createClass({
    handleChange: function (e) {
        this.props.changedRoomRate(e.target.value);
    },
    render: function() {
        var text = "";
        for (var i = 0; i < this.props.data.descriptions.length; i++) {
            text = text  + this.props.data.descriptions[i] + ". ";
        }
        return (<div className="mdl-grid">
                <input className="mdl-cell mdl-cell--4-col" type="radio" name="room" value={this.props.data.total_amount.amount} onChange={this.handleChange} />
                <p id="price">{this.props.data.total_amount.amount} "$"</p>
                <p className="mdl-cell mdl-cell--7-col" id="roomType"> {this.props.data.room_type_info.room_type} </p>
                <p className="mdl-cell mdl-cell--7-col" id="roomDescription">{text}</p>
            </div>
        );
    }
});
var RoomsDetails = React.createClass({
    getInitialState: function() {
        return {
            selectedRoomRate: this.props.roomsData.rooms[0].total_amount.amount
        }
    },
    changedRoomRate: function(rate) {
        this.setState({
            selectedRoomRate: rate
        });
    },

    render: function() {
        var this_= this;
        return (
            <div id="roomInfo">
                <h6> <b>SELECT NIGHTLY RATE </b></h6>
                {this.props.roomsData.rooms.map(function(result) {
                    return <Room key={result.room_type_code} data={result}  changedRoomRate={this_.changedRoomRate}/>;
                })}
                <p id="selectedRoomRate">{this.state.selectedRoomRate} "USD"</p>
            </div>
        );
    }
});

var Section = React.createClass({

    componentDidMount: function() {
        var acc = document.getElementsByClassName("accordion");
        var i;

        for (i = 0; i < acc.length; i++) {
            acc[i].onclick = function(){
                this.classList.toggle("active");
                this.nextElementSibling.classList.toggle("show");
            }
        }
    },

    render: function() {
        return (
            <div>
                <button className="accordion" title={this.props.data.min_daily_rate.amount}>{this.props.data.property_name} </button>
                <div className="panel">
                    <HotelDetails details={this.props.data}/>
                    <RoomsDetails roomsData={this.props.data}/>
                </div>
            </div>
        );
    }
})

var Container = React.createClass({
    buildSections: function(sectionList){
        var sections = sectionList.map(this.buildSection);
        return sections;
    },
    buildSection: function(section){
        /* Remember to add a 'key'. React wants you to add an identifier when you instantiate a component multiple times */
        return <Section key={section.property_code} data={section} />
    },
    render: function() {
        var sections = this.buildSections(this.props.data);
        return (
            <div className="Results">
                {sections}
            </div>
        );
    }
});

var SearchResult = React.createClass({

    getInitialState: function() {
        return {
            backendData: this.props.searchResult.results
        }
    },

    propertiesChanged: function(properties) {
        if (properties) {
            this.setState({
                backendData: properties.results
            })
        }
    },
    
    componentWillReceiveProps: function(nextProps) {
        this.propertiesChanged(nextProps.searchResult)
    },
    render: function() {
        return (
            <div className="mdl-cell mdl-cell--8-col" id="mainPanel">
                <p className="flow-text" id="mainText">Shop Results </p>
                <h5 id="note">LOWEST AVAILABLE NIGHTLY RATE PER ROOM</h5>
                <Container data={this.state.backendData}></Container>
            </div>
        );
    }
});
export default SearchResult;
