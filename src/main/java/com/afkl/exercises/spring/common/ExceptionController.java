package com.afkl.exercises.spring.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Throwable.class)
    public HttpEntity handleGlobalException() {
        return new ResponseEntity(SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public HttpEntity handleBadRequest() {
        return new ResponseEntity(BAD_REQUEST);
    }

}
