package com.osmi.store.app.products.common.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.osmi.store.app.products.common.exception.ResourceNotFoundException;
import com.osmi.store.app.products.common.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(
            ResourceNotFoundException ex,
            HttpServletRequest request) {

        ApiResponse<Void> response = new ApiResponse<>(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURI(),
                false,
                null
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneric(
            Exception ex,
            HttpServletRequest request) {

        ApiResponse<Void> response = new ApiResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Unexpected error occurred",
                request.getRequestURI(),
                false,
                null
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}