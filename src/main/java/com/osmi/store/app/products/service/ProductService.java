package com.osmi.store.app.products.service;

import com.osmi.store.app.products.domain.model.Product;

public interface ProductService {

	Product createProduct(Product request);

	Product getProductById(Long id);
}