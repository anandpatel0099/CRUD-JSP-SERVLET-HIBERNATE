package com.marlabs.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_MASTER2")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_Id")
	private Long id;
	@Column(name="product_name")
	private String product_name;
	@Column(name="product_symbol")
	private String product_symbol;
	

	public Product() {
		
	}

	public Product(String product_name, String product_symbol) {
		this.product_name = product_name;
		this.product_symbol = product_symbol;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_symbol() {
		return product_symbol;
	}

	public void setProduct_symbol(String product_symbol) {
		this.product_symbol = product_symbol;
	}


	
}
