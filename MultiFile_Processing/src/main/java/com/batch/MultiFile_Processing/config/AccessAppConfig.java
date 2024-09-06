package com.batch.MultiFile_Processing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 07-Sept-2024
 * @time 12:17:55 am
 */
@Component
public class AccessAppConfig {

	 @Autowired
	    private Environment env;

	    public void printConfig() {
	        String appName = env.getProperty("spring.application.name");
	        String serverPort = env.getProperty("server.port");
	        
	        System.out.println("Application Name: " + appName);
	        System.out.println("Server Port: " + serverPort);
	    }
}
