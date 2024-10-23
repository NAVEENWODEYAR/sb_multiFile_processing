package com.example.demo.dto;
/**
 * @author Naveen Wodeyar
 * @date 23-Oct-2024
 * @time 11:57:28 pm
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SalesDTOTest {

    @Test
    public void testConstructorAndGetters() {
        SalesDTO salesDTO = new SalesDTO(1L, 1001L, 501L, LocalDate.now(), 199.99, "New York", "USA");

        assertEquals(1L, salesDTO.getSale_id());
        assertEquals(1001L, salesDTO.getProduct_id());
        assertEquals(501L, salesDTO.getCustomer_id());
        assertNotNull(salesDTO.getSale_date());
        assertEquals(199.99, salesDTO.getSale_amount());
        assertEquals("New York", salesDTO.getStore_location());
        assertEquals("USA", salesDTO.getCountry());
    }

    @Test
    public void testSetters() {
        SalesDTO salesDTO = new SalesDTO();
        salesDTO.setSale_id(2L);
        salesDTO.setProduct_id(1002L);
        salesDTO.setCustomer_id(502L);
        salesDTO.setSale_date(LocalDate.now().minusDays(1));
        salesDTO.setSale_amount(299.99);
        salesDTO.setStore_location("Los Angeles");
        salesDTO.setCountry("USA");

        assertEquals(2L, salesDTO.getSale_id());
        assertEquals(1002L, salesDTO.getProduct_id());
        assertEquals(502L, salesDTO.getCustomer_id());
        assertEquals(LocalDate.now().minusDays(1), salesDTO.getSale_date());
        assertEquals(299.99, salesDTO.getSale_amount());
        assertEquals("Los Angeles", salesDTO.getStore_location());
        assertEquals("USA", salesDTO.getCountry());
    }

    @Test
    public void testEqualsAndHashCode() {
        SalesDTO salesDTO1 = new SalesDTO(1L, 1001L, 501L, LocalDate.now(), 199.99, "New York", "USA");
        SalesDTO salesDTO2 = new SalesDTO(1L, 1001L, 501L, LocalDate.now(), 199.99, "New York", "USA");

        assertEquals(salesDTO1, salesDTO2);
        assertEquals(salesDTO1.hashCode(), salesDTO2.hashCode());

        salesDTO2.setSale_id(2L);
        assertNotEquals(salesDTO1, salesDTO2);
    }

    @Test
    public void testToString() {
        SalesDTO salesDTO = new SalesDTO(1L, 1001L, 501L, LocalDate.now(), 199.99, "New York", "USA");
        String expectedString = "SalesDTO [sale_id=1, product_id=1001, customer_id=501, sale_date=" + salesDTO.getSale_date() +
                ", sale_amount=199.99, store_location=New York, country=USA]";
        
        assertEquals(expectedString, salesDTO.toString());
    }
}
