package com.example.demo.dto;

import java.time.LocalDate;

/**
 * @author Naveen Wodeyar
 * @date 14-Sept-2024
 * @time 10:42:44 am
 */
public record SalesDTO(
						Long sale_id,
						Long product_id,
						Long customer_id,
						LocalDate sale_date,
						Double sale_amount,
						String store_location,
						String country
		) {
	
	

}
