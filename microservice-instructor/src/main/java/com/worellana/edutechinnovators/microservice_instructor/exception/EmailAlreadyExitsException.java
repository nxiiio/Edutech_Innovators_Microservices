package com.worellana.edutechinnovators.microservice_instructor.exception;

public class EmailAlreadyExitsException extends RuntimeException {
    public EmailAlreadyExitsException(String message) {
        super(message);
    }
}
