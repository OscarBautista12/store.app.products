package com.osmi.store.app.products.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osmi.store.app.products.domain.model.Product;
import com.osmi.store.app.products.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService service;

	public ProductController(ProductService service) {
		this.service = service;
	}
	

	@PostMapping
	public Product create(@Valid @RequestBody Product request) {
		return service.createProduct(request);
	}

	
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return service.getProductById(id);
	}
}