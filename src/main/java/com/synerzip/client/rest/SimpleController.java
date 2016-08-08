package com.synerzip.client.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest")
@RestController
public class SimpleController {
	
	@RequestMapping(value = "/hello", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleResponse> hello() {
		return new ResponseEntity<SimpleResponse>(new SimpleResponse("Happy Coding with Spring...."), HttpStatus.OK);
	}
	
	public static class SimpleResponse {
		private String message;
		public SimpleResponse(String message) {
			this.message = message;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
}
