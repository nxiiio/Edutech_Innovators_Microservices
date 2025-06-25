package com.worellana.edutechinnovators.microservice_instructor.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResponse {
    private String error;
    private String exception;
    private int status;
    private Date date;
}
