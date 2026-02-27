package com.osmi.store.app.products.service.impl;

import org.springframework.stereotype.Service;

import com.osmi.store.app.products.domain.model.Product;
import com.osmi.store.app.products.repository.ProductRepository;
import com.osmi.store.app.products.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product createProduct(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
}