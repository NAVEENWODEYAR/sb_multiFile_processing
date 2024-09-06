package com.batch.MultiFile_Processing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Naveen K Wodeyar
 * @date 06/09/2024
 */
@RestController
@RequestMapping("/java")
public class JavaVersionEndPoint {
	
	@GetMapping
	public String getVersion() {
		
		return "JAVA VERSION: "+System.getProperty("java.version");
	}

}
