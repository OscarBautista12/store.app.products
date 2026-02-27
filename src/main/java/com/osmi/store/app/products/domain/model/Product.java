package com.osmi.store.app.products.domain.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // Ignora campos null en el JSON
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id") // Garantiza que se incluya en el JSON
	private Long id;

	@Column(nullable = false)
	@JsonProperty("name")
	private String name;

	@Column(length = 2000)
	@JsonProperty("description")
	private String description;

	@Column(nullable = false)
	@JsonProperty("brand")
	private String brand;

	@Column(nullable = false)
	@JsonProperty("categoryId")
	private Long categoryId;

	@Column(nullable = false)
	@JsonProperty("basePrice")
	private BigDecimal basePrice;

	@Column(nullable = false)
	@JsonProperty("baseDiscountPercentage")
	private BigDecimal baseDiscountPercentage;
}