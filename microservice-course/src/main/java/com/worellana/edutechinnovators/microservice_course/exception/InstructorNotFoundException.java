package com.worellana.edutechinnovators.microservice_course.exception;

public class InstructorNotFoundException extends RuntimeException {
    public InstructorNotFoundException(String message) {
        super(message);
    }
}
