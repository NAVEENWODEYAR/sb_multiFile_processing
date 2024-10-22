package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author Naveen Wodeyar
 * @date 22-Oct-2024
 * @time 11:52:08 pm
 */
@RestController
@RequestMapping("/api/batch")
public class BatchController {
	
	private static final Logger log = LoggerFactory.getLogger(BatchController.class);
	
	@GetMapping
	public String testConnection() {
		log.info("inside testConnection()");
		return "Batch_Processing_App_connected,,";
	}

}
