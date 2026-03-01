package com.osmi.store.app.products.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductUpdateRequest {

	@NotBlank
	private String name;

	private String description;

	@NotBlank
	private String brand;

	@NotNull
	private Long categoryId;

	@NotNull
	@Positive
	private BigDecimal basePrice;

	@NotNull
	@Positive
	private BigDecimal baseDiscountPercentage;
	
	@Column(name = "active", nullable = false)
	private Integer active;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getBaseDiscountPercentage() {
		return baseDiscountPercentage;
	}

	public void setBaseDiscountPercentage(BigDecimal baseDiscountPercentage) {
		this.baseDiscountPercentage = baseDiscountPercentage;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
	
	
}