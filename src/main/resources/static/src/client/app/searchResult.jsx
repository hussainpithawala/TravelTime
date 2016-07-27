import React from 'react';
import Collapsible from 'react-collapsible';

var Section = React.createClass({
    render: function() {
        return (
            <Collapsible class ="Result" triggerText={this.props.data.property_name}>
                <p>{this.props.data.marketing_text}.</p>
                <p>It can even be another Collapsible component. Check out the next section!</p>
            </Collapsible>
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
            backendData: []
        }
    },

    componentDidMount: function() {
        console.log(this.props.searchResult);
        this.setState({
            backendData :  [
                {
                    "property_code": 0,
                    "property_name":"Section 1",
                    "marketing_text":"Our content for the section 1"
                },
                {
                    "property_code": 1,
                    "property_name":"Section 2",
                    "marketing_text":"Our content for the section 2"
                },
                {
                    "property_code": 2,
                    "property_name":"Section 3",
                    "marketing_text":"Our content for the section 3"
                }
            ]
        });
    },
    render: function() {
        if (this.props.searchResult) {
            this.setState({
                backendData: this.props.searchResult.results
            })
        }
        return (
            <div className="mdl-cell mdl-cell--8-col" id="mainPanel">
                <p className="flow-text" id="mainText">Shop Results </p>
                <Container data={this.state.backendData}></Container>
            </div>
        );
    }
});
export default SearchResult;
