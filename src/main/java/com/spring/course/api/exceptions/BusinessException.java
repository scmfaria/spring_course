package com.spring.course.api.exceptions;

public class BusinessException extends RuntimeException {

    private static final long serialVersionIUD = 1L;

    public BusinessException(String message) {
        super(message);
    }
}