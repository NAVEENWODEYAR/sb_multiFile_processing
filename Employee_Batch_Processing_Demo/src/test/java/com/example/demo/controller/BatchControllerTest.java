package com.example.demo.controller;
import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.core.env.Environment;
/**
 * @author Naveen Wodeyar
 * @date 23-Oct-2024
 * @time 1:50:01 pm
 */
@WebMvcTest(BatchController.class)
public class BatchControllerTest {
	
	private static final Logger log = LoggerFactory.getLogger(BatchControllerTest.class);

    private MockMvc mockMvc;

    @InjectMocks
    private BatchController batchController;

    @Mock
    private Environment environment;

    @Value("${spring.application.name}")
    private String applicationName = "Batch_Processing_App";

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(batchController).build();
    }

    @Test
    @DisplayName(value = "TestConnection test")
    public void testConnection() throws Exception {
    			log.info("inside test connection test");     
    			mockMvc.perform(get("/api/batch"))
                .andExpect(status().isOk())
                .andExpect(content().string("Batch_Processing_App_connected,,"));
    }

    @Test
    @DisplayName(value = "get port unit test")
    public void getPort() throws Exception {
    	log.info(applicationName);
        when(environment.getProperty("server.port")).thenReturn("8080");
        mockMvc.perform(get("/api/batch/port")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Port: 8080")))
                .andExpect(content().string(containsString("Application Name: " + applicationName)));
    }
}
