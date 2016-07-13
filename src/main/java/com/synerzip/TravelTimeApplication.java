package com.synerzip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.synerzip.infra.security.ApplicationSecurity;

@SpringBootApplication
@Configuration
public class TravelTimeApplication {	
	@Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
    	return new ApplicationSecurity();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TravelTimeApplication.class, args);
	}
}
