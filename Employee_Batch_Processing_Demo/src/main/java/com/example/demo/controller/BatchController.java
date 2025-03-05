package com.example.demo.controller;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Naveen Wodeyar
 * @date 22-Oct-2024
 * @time 11:52:08 pm
 */

@RestController
@RequestMapping("/api/batch")
public class BatchController {
	
	private static final Logger log = LoggerFactory.getLogger(BatchController.class);
	
	@Value("${spring.application.name}")
    private String applicationName;

    private final Environment environment;

    @Autowired
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
        String port = environment.getProperty("server.port", "unknown");
        log.info("inside getPort() - Port: {}, Application Name: {}", port, applicationName);
        return String.format("Batch_Processing_App_connected,, Port: %s, Application Name: %s", port, applicationName);
    }
}
