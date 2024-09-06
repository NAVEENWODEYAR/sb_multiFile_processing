package com.batch.MultiFile_Processing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MultiFileProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiFileProcessingApplication.class, args);
		System.out.println("\n*******************\nFILE_PROCESSING");
	}

	 @Bean
	    public CommandLineRunner printJavaVersion() {
	        return args -> {
	            String javaVersion = System.getProperty("java.version");
	            System.out.println("\n#############################\n");
	            System.out.println("JAVA VERSOIN: " + javaVersion);
	            System.out.println("\n#############################\n");
	        };
	    }
}
