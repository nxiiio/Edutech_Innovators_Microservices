package com.worellana.edutechinnovators.microservice_instructor.controller;

import com.worellana.edutechinnovators.microservice_instructor.exception.EmailAlreadyExitsException;
import com.worellana.edutechinnovators.microservice_instructor.exception.ErrorResponse;
import com.worellana.edutechinnovators.microservice_instructor.exception.InstructorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validationFail(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse.builder()
                .error("Validation Failed, check the request JSON")
                .exception(e.getClass().getSimpleName())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .date(new Date()).build());
    }

    @ExceptionHandler(InstructorNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
                .error(e.getMessage())
                .exception(e.getClass().getSimpleName())
                .status(HttpStatus.NOT_FOUND.value())
                .date(new Date()).build());
    }

    @ExceptionHandler(EmailAlreadyExitsException.class)
    public ResponseEntity<ErrorResponse> exceptionGeneral(Exception e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ErrorResponse.builder()
                .error(e.getMessage())
                .exception(e.getClass().getSimpleName())
                .status(HttpStatus.CONFLICT.value())
                .date(new Date()).build());
    }
}
