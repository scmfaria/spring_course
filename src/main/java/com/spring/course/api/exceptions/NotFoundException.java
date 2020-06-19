package com.spring.course.api.exceptions;

public class NotFoundException extends BusinessException {

    private static final long serialVersionIUD = 1L;

    public NotFoundException(String message) {
        super(message);
    }
}