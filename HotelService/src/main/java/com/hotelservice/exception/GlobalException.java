package com.hotelservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        String message = ex.getMessage();
        Map<String,Object> response = new HashMap<>();
        response.put("Message",message);
        response.put("Success",HttpStatus.NOT_FOUND);
        response.put("Status",false);
        return ResponseEntity.ok(response);
    }
}
