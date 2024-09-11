package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * @author Naveen Wodeyar
 * @date 11-Sept-2024
 * @time 9:42:07 pm
 */
@Entity
public class EmployeeData {
	
	@Id
	@Column(name = "EMP_ID")
	private Integer id;
	
	@Column(name = "FIRST_NAME")	
	private String first_name;
	
	@Column(name = "LAST_NAME")
	private String last_name;
	
	@Column(name = "EMP_EMAIL")
	private String email;
	
	@Column(name = "EMP_GENDER")
	private String gender;
	
	@Column(name = "EMP_CONTACTNO")
	private String contactNo;
	
	@Column(name = "EMP_COUNTRY")
	private String country;
	
	@Column(name = "EMP_DOB")
	private Date dob;

}
