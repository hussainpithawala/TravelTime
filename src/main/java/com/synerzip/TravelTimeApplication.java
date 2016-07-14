package com.synerzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

import com.synerzip.infra.security.ApplicationSecurity;

@SpringBootApplication
@Configuration
@PropertySource("classpath:supplier.properties")
public class TravelTimeApplication {	
	@Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
    	return new ApplicationSecurity();
    }
	
	@Bean
	public RestTemplate provideRestTemplate(){
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TravelTimeApplication.class, args);
	}
}
