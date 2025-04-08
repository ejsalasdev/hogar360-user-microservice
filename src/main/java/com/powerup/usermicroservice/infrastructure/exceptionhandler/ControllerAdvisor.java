package com.powerup.usermicroservice.infrastructure.exceptionhandler;

import com.powerup.usermicroservice.domain.exceptions.*;
import com.powerup.usermicroservice.infrastructure.utils.constants.ExceptionHandlerConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ControllerAdvisor {
    
    @ExceptionHandler(ElementAlreadyExistsException.class)
    public ResponseEntity<ExceptionResponse> handleElementAlreadyExistsException(ElementAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidElementFormatException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidElementFormatException(InvalidElementFormatException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(RequiredFieldsException.class)
    public ResponseEntity<ExceptionResponse> handleRequiredFieldsException(RequiredFieldsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(InvalidElementLengthException.class)
    public ResponseEntity<ExceptionResponse> handleInvalidElementLengthException(InvalidElementLengthException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }
    
    @ExceptionHandler(UnderAgeException.class)
    public ResponseEntity<ExceptionResponse> handleUnderAgeException(UnderAgeException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionResponse(exception.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException exception) {
        Throwable mostSpecificCause = exception.getMostSpecificCause();
        String errorMessage = ExceptionHandlerConstants.GENERIC_REQUEST_FORMAT_ERROR;
        if (mostSpecificCause instanceof java.time.format.DateTimeParseException) {
            errorMessage = ExceptionHandlerConstants.BIRTH_DATE_REQUEST_FORMAT_ERROR;
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(errorMessage, LocalDateTime.now()));
    }
}
