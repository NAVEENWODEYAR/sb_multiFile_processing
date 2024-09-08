package com.batch.MultiFile_Processing.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author NaveenWodeyar
 * @date 07-Sept-2024
 * @time 12:48:16 am
 */
@Tag(name = "Test_Controller",description = "API to test the applicaion status,")
@RestController
@RequestMapping("/v1")
public class TestController {
	
	private static final Logger FILE_LOG = LoggerFactory.getLogger(TestController.class);
	
	@GetMapping
	public ResponseEntity<?> greet(){
		FILE_LOG.info("greet() accessed on:"+new Date());
		return ResponseEntity.status(HttpStatus.OK)
				.header("", "")
				.body("Welcome to\n MULTIFILE_PROCESSING");
	}

}
