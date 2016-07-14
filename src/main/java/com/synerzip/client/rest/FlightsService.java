package com.synerzip.client.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.synerzip.supplier.service.AmadeusSupplierService;

@RestController
public class FlightsService {

	@Autowired
	AmadeusSupplierService amadeusService;
	
	@RequestMapping(value = "/rest/lowfareflightsearch", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
	public String lowFareFlightSearch(WebRequest webRequest) {
		Map<String, String[]> params = webRequest.getParameterMap();
		String response = amadeusService.getLowFareFlightSearchResponse(params);
		return response;
	}
}
