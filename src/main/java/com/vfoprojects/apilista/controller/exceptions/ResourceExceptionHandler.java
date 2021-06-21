package com.vfoprojects.apilista.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.vfoprojects.apilista.service.exceptions.DataIntegrityViolationException;
import com.vfoprojects.apilista.service.exceptions.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler implements Serializable {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {

        StandardError error = new StandardError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<StandardError>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        ValidationError error = new ValidationError(Instant.now(), HttpStatus.BAD_REQUEST.value(), "Erro de validação",
                request.getRequestURI());

        for(FieldError x : e.getBindingResult().getFieldErrors()){
            error.addError(x.getDefaultMessage());
        }

        return new ResponseEntity<StandardError>(error, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrity(DataIntegrityViolationException e, HttpServletRequest request) {

        StandardError error = new StandardError(Instant.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(),
                request.getRequestURI());

        return new ResponseEntity<StandardError>(error, HttpStatus.BAD_REQUEST);
    }

}
