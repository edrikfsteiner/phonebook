package com.phonebook.handler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.phonebook.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodNotValid(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream()
            .map(FieldError::getField)
            .collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream()
            .map(FieldError::getDefaultMessage)
            .collect(Collectors.joining(", "));

        return new ResponseEntity<>(
            ValidationExceptionDetails.builder()
                .fields(fields)
                .fieldsMessage(fieldsMessage)
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .details(ex.getMessage())
                .build(),
            HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<Object> handleInternalServer(InternalServerException ex) {
        return new ResponseEntity<>(
            ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .details(ex.getMessage())
                .build(),
            HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFound(NotFoundException ex) {
        return new ResponseEntity<>(
            ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .details(ex.getMessage())
                .build(),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequest(BadRequestException ex) {
        return new ResponseEntity<>(
            ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .details(ex.getMessage())
                .build(),
            HttpStatus.BAD_REQUEST
        );
    }
}