package com.userservice.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
public class ApiResponse {

    private String message;

    private boolean sucess;

    private HttpStatus status;

    private Object data;

    public ApiResponse(String message, boolean b, HttpStatus httpStatus) {
        this.message = message;
        this.sucess = b;
        this.status= httpStatus;
    }

    public ApiResponse(String message, boolean sucess, HttpStatus status, Object data) {
        this.message = message;
        this.sucess = sucess;
        this.status = status;
        this.data = data;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResponse() {
    }
}
