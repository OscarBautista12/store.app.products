package com.osmi.store.app.products.common.response;

import java.time.LocalDateTime;

public class ApiResponse<T> {

    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String path;
    private boolean success;
    private T data;

    public ApiResponse(int status, String message, String path, boolean success, T data) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.path = path;
        this.success = success;
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getData() {
        return data;
    }
}