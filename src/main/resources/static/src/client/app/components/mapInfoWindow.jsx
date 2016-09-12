import React from 'react';

export default class MapInfoWindow extends React.Component {
	render() {
		return (
			<div className="row">
  			<div className="col-sm-12 col-md-12">
    			<div className="thumbnail">
      			<div className="caption">
        			<h3>{this.props.hotelInfo.property_name}</h3>
        			<p>{this.props.hotelInfo.address.line1 + ',' + this.props.hotelInfo.address.postal_code
}</p>
							<div>
								{this.props.hotelInfo.contacts.map(function(contact) {
          				return <p key={contact.type} > {contact.type} : {contact.detail} </p>;
        				})}
        			</div>	
      			</div>
    			</div>
  			</div>
			</div>
		);
	}
}