package com.synerzip.client.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.supplier.amadeus.model.flights.validator.RequestValidator;
import com.synerzip.supplier.amadeus.model.hotel.HotelSearchRQ;
import com.synerzip.supplier.amadeus.model.hotel.HotelSearchRS;
import com.synerzip.supplier.service.AmadeusHotelService;

@RestController
public class HotelsController {

	private Logger logger = LoggerFactory.getLogger(HotelsController.class);

	@Autowired
	private RequestValidator requestValidator;
	
	@Autowired
	private AmadeusHotelService amadeusHotelService;

	@RequestMapping(value = "/rest/hotelSearchByAirportCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelSearchRS> searchHotelsByAirportCode(@Valid @RequestBody HotelSearchRQ hotelSearchRQ) {
		return new ResponseEntity<HotelSearchRS>(amadeusHotelService.searchHotelsByAirportCode(hotelSearchRQ),
				HttpStatus.OK);
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(requestValidator);
	}
}
