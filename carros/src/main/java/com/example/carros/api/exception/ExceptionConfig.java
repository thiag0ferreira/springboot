package com.example.carros.api.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler({
            EmptyResultDataAccessException.class
    })
    public ResponseEntity erroNotFound(Exception ex) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler({
            IllegalArgumentException.class
    })
    public ResponseEntity erroBadRequest (Exception ex) {
        return ResponseEntity.badRequest().build();
    }
}
