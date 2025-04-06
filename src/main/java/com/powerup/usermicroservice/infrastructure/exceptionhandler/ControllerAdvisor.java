package com.powerup.usermicroservice.infrastructure.exceptionhandler;

import com.powerup.usermicroservice.domain.exceptions.ElementAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleElementAlreadyExistsException(ElementAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }
}
