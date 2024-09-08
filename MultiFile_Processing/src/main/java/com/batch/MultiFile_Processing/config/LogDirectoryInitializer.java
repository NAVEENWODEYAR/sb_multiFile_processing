package com.batch.MultiFile_Processing.config;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author NaveenWodeyar
 * @date 07-Sept-2024
 * @time 1:16:10 am
 */
@Component
public class LogDirectoryInitializer implements CommandLineRunner {

	@Override
    public void run(String... args) throws Exception {
        File logDir = new File("log");
        if (!logDir.exists()) {
            boolean created = logDir.mkdirs();
            if (created) {
                System.out.println("Log directory created: " + logDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create log directory: " + logDir.getAbsolutePath());
            }
        } else {
            System.out.println("Log directory already exists: " + logDir.getAbsolutePath());
        }
    }
}
