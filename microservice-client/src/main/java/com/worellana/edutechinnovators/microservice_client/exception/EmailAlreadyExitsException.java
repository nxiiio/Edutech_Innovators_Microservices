package com.worellana.edutechinnovators.microservice_client.exception;

public class EmailAlreadyExitsException extends RuntimeException {
    public EmailAlreadyExitsException(String message) {
        super(message);
    }
}
