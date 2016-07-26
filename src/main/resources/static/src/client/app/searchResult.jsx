import React from 'react';
import Collapsible from 'react-collapsible';

var Section = React.createClass({
    render: function() {
        return (
            <Collapsible class ="Result" triggerText={this.props.data.title}>
                <p>{this.props.data.content}.</p>
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
        return <Section key={section.id} data={section} />
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
        this.setState({
            backendData :  [
                {
                    "id": 0,
                    "title":"Section 1",
                    "content":"Our content for the section 1"
                },
                {
                    "id": 1,
                    "title":"Section 2",
                    "content":"Our content for the section 2"
                },
                {
                    "id": 2,
                    "title":"Section 3",
                    "content":"Our content for the section 3"
                }
            ]
        });
    },
    render: function() {
        return (
            <div className="mdl-cell mdl-cell--8-col" id="mainPanel">
                <p className="flow-text" id="mainText">Shop Results </p>
                <Container data={this.state.backendData}></Container>
            </div>
        );
    }
});
export default SearchResult;
