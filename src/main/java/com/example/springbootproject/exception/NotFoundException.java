package com.example.springbootproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends NullPointerException {
    public NotFoundException(String message){
        super(message);
    }
}
