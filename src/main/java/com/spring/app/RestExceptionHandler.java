package com.spring.app;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Exception handler
 *
 * @author Lyubov Ruzanova
 */
@ControllerAdvice
public class RestExceptionHandler  {

    /**
     * Catch InvalidDataAccessResourceUsageException
     * @return response to the client that there are some problems at the DAO layer
     */
    @ExceptionHandler(value = DataNotFoundException.class)
    protected ResponseEntity<String> catchDataNotFoundException(DataNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Catch RuntimeException
     * @return response to the client that something goes wrong
     */
    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity<String> catchRuntimeException() {
        return ResponseEntity.badRequest().body(MessageEnum.ERROR_AT_RUNTIME.getMessage());
    }

    /**
     * Catch InvalidDataAccessResourceUsageException
     * @return response to the client that there are some problems at the DAO layer
     */
    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
    protected ResponseEntity<String> catchInvalidDataAccess() {
        return ResponseEntity.badRequest().body(MessageEnum.ERROR_INVALID_DATA_ACCESS.getMessage());
    }
}

