package com.osmi.store.app.products.service;

import java.util.List;

import com.osmi.store.app.products.domain.model.Product;
import com.osmi.store.app.products.domain.model.ProductUpdateRequest;
import com.osmi.store.app.products.dto.request.ProductCreateRequest;
import com.osmi.store.app.products.dto.response.ProductResponse;

public interface ProductService {

	ProductResponse create(ProductCreateRequest request, String idempotencyKey);

	Product getProductById(Long id);

	Product updateProduct(Long id, ProductUpdateRequest productUpdate);

	void deleteProduct(Long id);

	List<Product> getAllProducts();
}