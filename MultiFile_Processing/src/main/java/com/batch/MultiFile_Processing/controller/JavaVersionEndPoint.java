package com.batch.MultiFile_Processing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Naveen K Wodeyar
 * @date 06/09/2024
 */
@RestController
@Endpoint(id = "java")
public class JavaVersionEndPoint {
	
	private static final Logger LOOGER = LoggerFactory.getLogger(JavaVersionEndPoint.class);
	
	@ReadOperation
	public String getVersion() {
		LOOGER.info(getVersion());
		return "JAVA VERSION: "+System.getProperty("java.version");
	}

}
