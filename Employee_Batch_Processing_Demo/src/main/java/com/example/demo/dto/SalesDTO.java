package com.example.demo.dto;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Naveen Wodeyar
 * @date 14-Sept-2024
 * @time 10:42:44 am
 */

public class SalesDTO{
	
			private Long sale_id;
			private Long product_id;
			private Long customer_id;
			private LocalDate sale_date;
			private Double sale_amount;
			private String store_location;
			private String country;

	public SalesDTO() {}

	public SalesDTO(Long sale_id, Long product_id, Long customer_id, LocalDate sale_date, Double sale_amount,
			String store_location, String country) {
		super();
		this.sale_id = sale_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.sale_date = sale_date;
		this.sale_amount = sale_amount;
		this.store_location = store_location;
		this.country = country;
	}

	/**
	 * @return the sale_id
	 */
	public Long getSale_id() {
		return sale_id;
	}

	/**
	 * @param sale_id the sale_id to set
	 */
	public void setSale_id(Long sale_id) {
		this.sale_id = sale_id;
	}

	/**
	 * @return the product_id
	 */
	public Long getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the customer_id
	 */
	public Long getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return the sale_date
	 */
	public LocalDate getSale_date() {
		return sale_date;
	}

	/**
	 * @param sale_date the sale_date to set
	 */
	public void setSale_date(LocalDate sale_date) {
		this.sale_date = sale_date;
	}

	/**
	 * @return the sale_amount
	 */
	public Double getSale_amount() {
		return sale_amount;
	}

	/**
	 * @param sale_amount the sale_amount to set
	 */
	public void setSale_amount(Double sale_amount) {
		this.sale_amount = sale_amount;
	}

	/**
	 * @return the store_location
	 */
	public String getStore_location() {
		return store_location;
	}

	/**
	 * @param store_location the store_location to set
	 */
	public void setStore_location(String store_location) {
		this.store_location = store_location;
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

	@Override
	public String toString() {
		return "SalesDTO [sale_id=" + sale_id + ", product_id=" + product_id + ", customer_id=" + customer_id
				+ ", sale_date=" + sale_date + ", sale_amount=" + sale_amount + ", store_location=" + store_location
				+ ", country=" + country + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, customer_id, product_id, sale_amount, sale_date, sale_id, store_location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesDTO other = (SalesDTO) obj;
		return Objects.equals(country, other.country) && Objects.equals(customer_id, other.customer_id)
				&& Objects.equals(product_id, other.product_id) && Objects.equals(sale_amount, other.sale_amount)
				&& Objects.equals(sale_date, other.sale_date) && Objects.equals(sale_id, other.sale_id)
				&& Objects.equals(store_location, other.store_location);
	}	

}
