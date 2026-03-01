package com.osmi.store.app.products.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.osmi.store.app.products.common.exception.ResourceNotFoundException;
import com.osmi.store.app.products.controller.ProductController;
import com.osmi.store.app.products.domain.model.Product;
import com.osmi.store.app.products.domain.model.ProductUpdateRequest;
import com.osmi.store.app.products.dto.request.ProductCreateRequest;
import com.osmi.store.app.products.dto.response.ProductResponse;
import com.osmi.store.app.products.repository.IdempotentOperationRepository;
import com.osmi.store.app.products.repository.ProductRepository;
import com.osmi.store.app.products.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository repository;
	private final IdempotentOperationRepository idempotentRepository;

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);

	public ProductServiceImpl(ProductRepository repository,
            IdempotentOperationRepository idempotentRepository) {
			this.repository = repository;
			this.idempotentRepository = idempotentRepository;
	}
	

	@Override
	public ProductResponse create(ProductCreateRequest request, String idempotencyKey) {

		log.info("Creating product with name: {}", request.getName());

	    if (idempotentRepository.existsByIdempotencyKey(idempotencyKey)) {
	        throw new RuntimeException("Duplicate request detected");
	    }
	    
		if (repository.existsByName(request.getName())) {
			throw new RuntimeException("Product already exists");
		}
		
		if (request.getBasePrice().compareTo(new BigDecimal("1000000")) > 0) {
		    throw new RuntimeException("Price exceeds allowed limit");
		}
		
		Product product = new Product();
		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setBrand(request.getBrand());
		product.setCategoryId(request.getCategoryId());
		product.setBasePrice(request.getBasePrice());
		product.setBaseDiscountPercentage(request.getBaseDiscountPercentage());
		product.setActive(1);
		product.setStock(request.getStock());

		Product saved = repository.save(product);

		return new ProductResponse(saved.getId(), 
				                   saved.getName(), 
				                   saved.getDescription(), 
				                   saved.getBrand(),
				                   saved.getCategoryId(), 
				                   saved.getBasePrice(), 
				                   saved.getBaseDiscountPercentage(), 
				                   saved.getStock());
	}

	@Override
	public Product getProductById(Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
	}

	@Transactional
	@Override
	public Product updateProduct(Long id, ProductUpdateRequest request) {

		Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

		product.setName(request.getName());
		product.setDescription(request.getDescription());
		product.setBrand(request.getBrand());
		product.setCategoryId(request.getCategoryId());
		product.setBasePrice(request.getBasePrice());
		product.setBaseDiscountPercentage(request.getBaseDiscountPercentage());
		product.setActive(request.getActive());

		return product; // JPA lo persiste automáticamente
	}

	@Transactional
	@Override
	public void deleteProduct(Long id) {

		Product product = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));

		product.setActive(0);
		repository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return repository.findAll();
	}
}