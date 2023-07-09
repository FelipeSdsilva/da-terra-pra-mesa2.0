package com.generationbrasil.daterrapramesa20.controllers.exceptions;

import com.generationbrasil.daterrapramesa20.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status  = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();

        err.setTimeStamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Entidade não encontrada");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());

        return ResponseEntity.status(status.value()).body(err);
    }
}
