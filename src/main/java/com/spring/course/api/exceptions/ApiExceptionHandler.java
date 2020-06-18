package com.spring.course.api.exceptions.ApiExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, 
        HttpHeader headers, HttpStatus status, WebRequest request) {

        var problema = new Problema();
        problema.setStatus(status.value());
        problema.setTitle("Um ou mais campos estão invalidos");
        problema.setDateHour(LocalDateTime.now());

        return super.handleExceptionInternal(ex, problema, headers, status, request);
    }
}