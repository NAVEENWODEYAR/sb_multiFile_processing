package com.example.demo.service.Impl;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.demo.service.MailService;

/**
 * @author Naveen Wodeyar
 * @date 08-Nov-2024
 * @time 10:05:54 pm
 */

@Service
public class MailServiceImpl implements MailService {

    private static final long serialVersionUID = 1L;

    private static final Logger log = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String sendMail() {
        long startTime = System.nanoTime(); // Start time for performance measurement
        long startMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // Start memory

        try {
            log.info("send mail()");
            // Code to send mail would be here, but currently it's not implemented

            // For the sake of this example, we simulate some mail sending logic
            // Simulating a small operation here
            Thread.sleep(1000);  // Simulating a delay for sending mail (1 second)

            return "Mail Sent Successfully";
        } catch (Exception e) {
            log.error("Error sending mail: " + e.getMessage());
            return "Failed to send mail";
        } finally {
            long endTime = System.nanoTime(); // End time for performance measurement
            long endMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(); // End memory

            long timeTaken = endTime - startTime; // Time in nanoseconds
            long memoryUsed = endMemory - startMemory; // Memory in bytes

            log.info("Time taken for sending mail: " + timeTaken + " ns");
            log.info("Memory used for sending mail: " + memoryUsed + " bytes");
        }
    }
}
