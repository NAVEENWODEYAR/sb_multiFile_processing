package com.example.demo.controller;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Naveen Wodeyar
 * @date 22-Oct-2024
 * @time 11:52:08 pm
 */
@RestController
@RequestMapping("/api/batch")
public class BatchController {
	
	private static final Logger log = LoggerFactory.getLogger(BatchController.class);
	
	  @Value("${spring.application.name}")
	    private String applicationName;

	    private final Environment environment;

	    public BatchController(Environment environment) {
	        this.environment = environment;
	    }
	    
	@GetMapping
	public String testConnection() {
		log.info("inside testConnection()");
		return "Batch_Processing_App_connected,,";
	}
	
	@GetMapping("/port")
    public String getPort() {
        Properties port = environment.getProperties();
        log.info("inside getPort() - Port: {}, Application Name: {}", port, applicationName);
        return String.format("Batch_Processing_App_connected,, Port: %s, Application Name: %s", port, applicationName);
    }

}
