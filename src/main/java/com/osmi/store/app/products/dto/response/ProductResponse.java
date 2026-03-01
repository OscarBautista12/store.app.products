package com.osmi.store.app.products.dto.response;

import java.math.BigDecimal;

public class ProductResponse {

	private Long id;
	private String name;
	private String description;
	private String brand;
	private Long categoryId;
	private BigDecimal basePrice;
	private BigDecimal baseDiscountPercentage;
	private Integer stock;

	public ProductResponse() {
	}

	public ProductResponse(Long id, String name, String description, String brand, Long categoryId,
			BigDecimal basePrice, BigDecimal baseDiscountPercentage, int stock) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.categoryId = categoryId;
		this.basePrice = basePrice;
		this.baseDiscountPercentage = baseDiscountPercentage;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getBrand() {
		return brand;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public BigDecimal getBaseDiscountPercentage() {
		return baseDiscountPercentage;
	}

	public Integer getStock() {
		return stock;
	}
	

}