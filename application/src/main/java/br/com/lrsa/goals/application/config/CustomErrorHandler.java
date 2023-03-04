package br.com.lrsa.goals.application.config;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomError> handleConstraintViolationException(ConstraintViolationException exception) {
        CustomError customError = new CustomError();
        customError.setStatus(HttpStatus.BAD_REQUEST.value());
        customError.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(customError);
    }
}
