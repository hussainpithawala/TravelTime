'use strict';

import React from 'react';
import TextInput from '../app/helpercomponents/textInput.jsx';
import renderer from 'react-test-renderer';

it('textInput with text type', () => {
    const component = renderer.create(
        <TextInput type='text' value='SAN' label='Location' name='Location'
htmlFor='Location' isRequired='true' onChange='onChangeLocation' messageRequired={'Location Required'}
list='locations'
    />
);
let tree = component.toJSON();
expect(tree).toMatchSnapshot();
});

it('textInput with date type', () => {
    const component = renderer.create(
    <TextInput type="date" value='2016-09-23' label='Check-In' name='CheckIn'
htmlFor='CheckIn' isRequired='true' onChange='onChangeFromDate'
messageRequired={'Check-in required'}
min='2016-09-20'
    />
);
let tree = component.toJSON();
expect(tree).toMatchSnapshot();
});