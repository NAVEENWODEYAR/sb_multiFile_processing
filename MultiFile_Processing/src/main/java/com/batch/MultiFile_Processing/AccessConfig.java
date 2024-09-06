package com.batch.MultiFile_Processing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 07-Sept-2024
 * @time 12:16:40 am
 */
@Component
public class AccessConfig {
	
	 @Value("${spring.application.name}")
	    private String appName;

	    @Value("${server.port}")
	    private int serverPort;

	    public void printConfig() {
	        System.out.println("Application Name: " + appName);
	        System.out.println("Server Port: " + serverPort);
	    }

}
