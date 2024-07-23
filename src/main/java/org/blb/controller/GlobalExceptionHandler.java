package org.blb.controller;


import jakarta.validation.ConstraintViolationException;
import org.blb.DTO.appDTO.ResponseErrors;
import org.blb.DTO.appDTO.StandardResponseDto;
import org.blb.exeption.NullArgException;
import org.blb.exeption.RestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestException.class)
    public ResponseEntity<StandardResponseDto> handlerNotFoundException(RestException exception) {
        return new ResponseEntity<>(new StandardResponseDto(exception.getMessage()), exception.getStatus());
    }


    @ExceptionHandler(NullArgException.class)
    public ResponseEntity<StandardResponseDto> handlerNullArgException(NullArgException exception) {
        return new ResponseEntity<>(new StandardResponseDto(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handlerConstraintViolationException(ConstraintViolationException exception) {

        StringBuilder responseMessage = new StringBuilder();

        exception.getConstraintViolations()
                .forEach(constraintViolation -> {
                    String message = constraintViolation.getMessage();
                    responseMessage.append(message);
                    responseMessage.append("\n");
                });
        return new ResponseEntity<>(responseMessage.toString(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ResponseErrors>> handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final List<ResponseErrors> errors = e.getBindingResult().getFieldErrors().stream()
                .map(error -> new ResponseErrors(error.getField(), error.getDefaultMessage()))
                .toList();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
