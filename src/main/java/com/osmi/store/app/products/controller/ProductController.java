package com.osmi.store.app.products.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.osmi.store.app.products.common.response.ApiResponse;
import com.osmi.store.app.products.domain.model.Product;
import com.osmi.store.app.products.domain.model.ProductUpdateRequest;
import com.osmi.store.app.products.dto.request.ProductCreateRequest;
import com.osmi.store.app.products.dto.response.ProductResponse;
import com.osmi.store.app.products.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService service;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> create(
            @RequestHeader("Idempotency-Key") String idempotencyKey,
            @Valid @RequestBody ProductCreateRequest request,
            HttpServletRequest httpRequest) {

        ProductResponse response = service.create(request, idempotencyKey);
		log.info("Creating product with name: {}", request.getName());

        ApiResponse<ProductResponse> apiResponse =
                new ApiResponse<>(
                        HttpStatus.CREATED.value(),
                        "Product created successfully",
                        httpRequest.getRequestURI(),
                        true,
                        response
                );

        
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProduct(
            @PathVariable Long id,
            HttpServletRequest httpRequest) {

        Product product = service.getProductById(id);

        ApiResponse<Product> response =
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Product retrieved successfully",
                        httpRequest.getRequestURI(),
                        true,
                        product
                );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductUpdateRequest request,
            HttpServletRequest httpRequest) {

        Product updated = service.updateProduct(id, request);

        ApiResponse<Product> response =
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Product updated successfully",
                        httpRequest.getRequestURI(),
                        true,
                        updated
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAll(
            HttpServletRequest httpRequest) {

        List<Product> products = service.getAllProducts();

        ApiResponse<List<Product>> response =
                new ApiResponse<>(
                        HttpStatus.OK.value(),
                        "Products retrieved successfully",
                        httpRequest.getRequestURI(),
                        true,
                        products
                );

        return ResponseEntity.ok(response);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable Long id,
            HttpServletRequest httpRequest) {

        service.deleteProduct(id);

        ApiResponse<Void> response = new ApiResponse<>(
                HttpStatus.OK.value(),
                "Product deleted successfully",
                httpRequest.getRequestURI(),
                true,
                null
        );

        return ResponseEntity.ok(response);
    }

}