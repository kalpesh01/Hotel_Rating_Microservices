package com.hotelservice.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource Not Found custom exception");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
