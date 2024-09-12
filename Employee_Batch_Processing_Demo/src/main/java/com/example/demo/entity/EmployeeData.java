package com.example.demo.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

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
	
	public EmployeeData() {}

	public EmployeeData(Integer id, String first_name, String last_name, String email, String gender, String contactNo,
			String country, Date dob) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.contactNo = contactNo;
		this.country = country;
		this.dob = dob;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactNo, country, dob, email, first_name, gender, id, last_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeData other = (EmployeeData) obj;
		return Objects.equals(contactNo, other.contactNo) && Objects.equals(country, other.country)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(first_name, other.first_name) && Objects.equals(gender, other.gender)
				&& Objects.equals(id, other.id) && Objects.equals(last_name, other.last_name);
	}

	@Override
	public String toString() {
		return "EmployeeData [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", gender=" + gender + ", contactNo=" + contactNo + ", country=" + country + ", dob=" + dob + "]";
	}
	
	
	


}
