import React from 'react';

var Section = React.createClass({
    toggleContent: function(){
        this.props.toggleOne(this.props.data.id)
    },
    getHeight: function(){
        if(this.props.open){
            return "3em"
        } else {
            return "0"
        }
    },
    render: function() {
        var style = { height: this.getHeight() }
        return (
            <div className={"section section" + this.props.data.id}>
                <h5 className="sectionTitle" onClick={this.toggleContent} >{this.props.data.title}</h5>
                <p className="sectionContent" style={style} >{this.props.data.content}</p>
            </div>
        );
    }
})

var Container = React.createClass({
    getInitialState: function(sectionList){
        return { openSectionIndex: -1 }
    },
    buildSections: function(sectionList){
        var sections = sectionList.map(this.buildSection);
        return sections;
    },
    buildSection: function(section, index){
        var openStatus = (index === this.state.openSectionIndex);
        /* Remember to add a 'key'. React wants you to add an identifier when you instantiate a component multiple times */
        return <Section key={section.id} data={section} toggleOne={this.toggleOne} open={openStatus} />
    },
    toggleOne: function(id){
        if(this.state.openSectionIndex === id){
            this.setState({openSectionIndex: -1});
        } else {
            this.setState({openSectionIndex: id});
        }
    },
    render: function() {
        var sections = this.buildSections(this.props.data);
        return (
            <div className="container">
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