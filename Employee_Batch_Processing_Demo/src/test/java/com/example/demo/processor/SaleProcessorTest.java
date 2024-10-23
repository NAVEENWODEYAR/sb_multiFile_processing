package com.example.demo.processor;
/**
 * @author Naveen Wodeyar
 * @date 23-Oct-2024
 * @time 11:54:26 pm
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.example.demo.dto.SalesDTO;

public class SaleProcessorTest {

    private SaleProcessor saleProcessor;

    @BeforeEach
    public void setUp() {
        saleProcessor = new SaleProcessor();
    }

    @Test
    public void testProcess() throws Exception {
        // Given
        SalesDTO salesDTO = new SalesDTO();
        // Set properties for salesDTO as needed
        salesDTO.setSomeProperty("Test Value");

        // When
        SalesDTO processedItem = saleProcessor.process(salesDTO);

        // Then
        assertNotNull(processedItem);
        assertEquals("Test Value", processedItem.getSomeProperty()); 
    }
}
