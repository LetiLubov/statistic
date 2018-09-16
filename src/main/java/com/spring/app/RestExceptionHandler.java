package com.spring.app;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler
 * Return a message to client to explain problem
 *
 * @author Lyubov Ruzanova
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity<String> catchRuntimeException() {
        return ResponseEntity.badRequest().body(MessageEnum.ERROR_AT_RUNTIME.getErrorMessage());
    }

    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
    protected ResponseEntity<Object> catchInvalidDataAccess() {
        return ResponseEntity.badRequest().body(MessageEnum.ERROR_INVALID_DATA_ACCESS.getErrorMessage());
    }
}

