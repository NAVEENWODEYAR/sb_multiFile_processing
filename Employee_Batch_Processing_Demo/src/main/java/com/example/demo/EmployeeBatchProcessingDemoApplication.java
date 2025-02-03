package com.example.demo;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author Naveen Wodeyar
 * @date 13-Jan-2025
 */

@EnableRetry
@EnableCaching
@EnableJpaRepositories
@SpringBootApplication
@EnableScheduling
public class EmployeeBatchProcessingDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeeBatchProcessingDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeBatchProcessingDemoApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner printJavaVersion() {
        return args -> {
            String javaVersion = System.getProperty("java.version");
            System.out.println("\n#############################\n");
            System.out.println("JAVA VERSION: " + javaVersion);
            System.out.println("\n#############################\n");
        };
    }
	
	@Scheduled(cron = "0 0/5 * * * ?")
	public void cronJob() {
		System.out.println("SERVER: RUNNING");
		log.info("SERVER_STATUS: {}",LocalDateTime.now());
	}

}
