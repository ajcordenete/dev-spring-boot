package com.ajcordenete.springrestcrud.rest;

import com.ajcordenete.springrestcrud.StudentNotFoundException;
import com.ajcordenete.springrestcrud.model.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception exception) {
        StudentErrorResponse errorResponse = new StudentErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
