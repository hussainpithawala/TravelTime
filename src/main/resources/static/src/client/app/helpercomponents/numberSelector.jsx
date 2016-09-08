import React from 'react';

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

export default NumberSelector;