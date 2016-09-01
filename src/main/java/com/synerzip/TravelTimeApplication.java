package com.synerzip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import com.synerzip.infra.security.ApplicationSecurity;
import com.synerzip.supplier.sabre.service.interceptor.AuthenticatingGetInterceptor;

@SpringBootApplication
@Configuration
@PropertySource("classpath:supplier.properties")
public class TravelTimeApplication {
	private static final Logger logger = LoggerFactory.getLogger(TravelTimeApplication.class);
	
	@Bean
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter(){
    	return new ApplicationSecurity();
    }
	
	@Bean(name="basic")
	public RestTemplate provideRestTemplate(){
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}
			
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
			}
		});
		return restTemplate;
	}

	@Autowired
	private AuthenticatingGetInterceptor authInterceptor;

	
	@Bean(name="sabre")
	public RestTemplate providesSpecificRestTemplate(){
		List<ClientHttpRequestInterceptor> ris = new ArrayList<>();
		ris.add(authInterceptor);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(ris);
		restTemplate.setErrorHandler(new ResponseErrorHandler() {
			@Override
			public boolean hasError(ClientHttpResponse response) throws IOException {
				return false;
			}
			
			@Override
			public void handleError(ClientHttpResponse response) throws IOException {
				logger.info(response.toString());
			}
		});
		return restTemplate;
	}
	
	@Bean
	public ThreadPoolTaskExecutor provideThreadPoolTaskExecutor() {
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(4);
		threadPoolTaskExecutor.setMaxPoolSize(16);
		threadPoolTaskExecutor.setQueueCapacity(20);
		
		threadPoolTaskExecutor.initialize();
		
		return threadPoolTaskExecutor;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TravelTimeApplication.class, args);
	}
}
