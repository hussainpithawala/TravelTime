import React from 'react';

var TextInput = React.createClass({
    // onChange event handling
    handleChange: function(e) {
        this.props.onChange(e.target.value);
        var isValidField = this.isValid(e.target);
    },
    // validation function
    isValid: function(inputValue) {
        // check required fields
        //alert("(inputValue.getAttribute('required')",(inputValue.getAttribute('required'));
        //console.log('inputValue',inputValue.required);
        if ((inputValue.getAttribute('required') != null) && (inputValue.value == '')) {
            inputValue.classList.add('error'); // add error class
            inputValue.focus();
            inputValue.nextSibling.textContent = inputValue.name + ' cannot be empty'; // Show error message
            return false;
        } else {
            inputValue.classList.remove('error'); // remove error class
            inputValue.nextSibling.textContent = '';
            //alert(inputValue.placeholder + 'should not be empty');
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
            {this.props}
            inputField =
                <input  className="form-control" value={this.props.value} name={this.props.name}
                        placeholder={this.props.name} ref={this.props.name}
                        required = {this.props.isRequired} onChange = {this.handleChange}
                        id={this.props.name} list={this.props.list}/>
        } else if (this.props.type == 'text') {
            inputField =
                <input className="form-control" value={this.props.value} name={this.props.name}
                       placeholder={this.props.name} ref={this.props.name}
                       required = {this.props.isRequired} onChange = {this.handleChange}
                       id={this.props.name} list={this.props.list}/>
        } else if(this.props.type == 'date' ) {
            inputField =
                <input type="date" className="form-control" value={this.props.value} name={this.props.name}
                       placeholder={this.props.name}ref={this.props.name} required = {this.props.isRequired}
                       onChange = {this.handleChange} id={this.props.name} data-type="date" min={this.props.min}/>
        }
        return (
            <div className="col-sm-6 ">
                <label htmlFor={this.props.name}>{this.props.name}</label>
                {inputField}
                <span className="error  errormsg"></span>
            </div>
        )
    }
});

export default TextInput;