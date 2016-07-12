package com.synerzip;

import javax.management.MBeanServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.integration.monitor.IntegrationMBeanExporter;
import org.springframework.jmx.export.annotation.AnnotationMBeanExporter;
import org.springframework.jmx.export.naming.ObjectNamingStrategy;
import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@Configuration
@EnableWebSecurity
public class TravelTimeApplication {

	@Bean
	public IntegrationMBeanExporter integrationMbeanExporter(
	           @Value("spring.jmx.default-domain") String domain, 
	           MBeanServer mBeanServer) {
	       IntegrationMBeanExporter exporter = new IntegrationMBeanExporter();
	       exporter.setDefaultDomain(domain);
	       exporter.setServer(mBeanServer);
	       return exporter;
	}
	
	@Bean
	@Primary
	public AnnotationMBeanExporter mbeanExporter(ObjectNamingStrategy namingStrategy, MBeanServer mBeanServer) {
	    AnnotationMBeanExporter exporter = new AnnotationMBeanExporter();
	    exporter.setRegistrationPolicy(RegistrationPolicy.FAIL_ON_EXISTING);
	    exporter.setNamingStrategy(namingStrategy);
	    exporter.setServer(mBeanServer);
	    return exporter;
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
    
	public static void main(String[] args) {
		SpringApplication.run(TravelTimeApplication.class, args);
	}
}
