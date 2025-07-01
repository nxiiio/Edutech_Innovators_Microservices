package com.worellana.edutechinnovators.microservice_course.controller;

import com.worellana.edutechinnovators.microservice_course.exception.CategoryNotFoundException;
import com.worellana.edutechinnovators.microservice_course.exception.CourseNotFoundException;
import com.worellana.edutechinnovators.microservice_course.exception.ErrorResponse;
import com.worellana.edutechinnovators.microservice_course.exception.InstructorNotFoundException;
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


    @ExceptionHandler({InstructorNotFoundException.class, CourseNotFoundException.class, CategoryNotFoundException.class})
    public ResponseEntity<ErrorResponse> notFound(Exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder()
                .error(e.getMessage())
                .exception(e.getClass().getSimpleName())
                .status(HttpStatus.NOT_FOUND.value())
                .date(new Date()).build());
    }
}
