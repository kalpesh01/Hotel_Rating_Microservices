package com.userservice.exception;

import com.userservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(Exception ex) {
        String message = ex.getMessage();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(message);
        apiResponse.setStatus(HttpStatus.NOT_FOUND);
        apiResponse.setSucess(true);
        return ResponseEntity.ok(apiResponse);
    }
}
