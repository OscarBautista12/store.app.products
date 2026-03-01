package com.osmi.store.app.products.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 100, message = "Name must be between 3 and 100 characters")
    private String name;

    @Size(max = 255, message = "Description cannot exceed 255 characters")
    private String description;

	@NotBlank(message = "Brand is required")
	private String brand;

	@NotNull(message = "Category id is required")
	@Positive(message = "Category id must be greater than zero")
	private Long categoryId;

    @NotNull(message = "Price is required")
    @DecimalMin(value = "0.01", message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price format is invalid")
    private BigDecimal basePrice;

	@NotNull(message = "Discount percentage is required")
	@DecimalMin(value = "0.0", inclusive = true)
	@DecimalMax(value = "100.0", inclusive = true)
	private BigDecimal baseDiscountPercentage;
	
    @NotNull(message = "Stock is required")
    @Min(value = 0, message = "Stock cannot be negative")
    @Max(value = 100000, message = "Stock exceeds allowed limit")
    private Integer stock;

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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	

}