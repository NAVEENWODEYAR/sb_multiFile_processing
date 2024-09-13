package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Naveen Wodeyar
 * @date 13-Sept-2024
 * @time 6:15:59 pm
 */
@Entity
public class ProductData {
	
	@Id
	private Integer productId;
	
	private String title;
	
	private String description;
	
	private Integer price;
	
	private Integer discount;

}
