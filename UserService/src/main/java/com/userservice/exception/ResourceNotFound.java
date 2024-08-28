package com.userservice.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound() {
        super("Resource Not Found custom exception");
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
