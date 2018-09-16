package com.spring.app;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler
 *
 * @author Lyubov Ruzanova
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Catch InvalidDataAccessResourceUsageException
     * @return response to the client that there are some problems at the DAO layer
     */
    @ExceptionHandler(value = DataNotFoundException.class)
    protected ResponseEntity<String> catchDataNotFoundException(DataNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

//    /**
//     * Catch RuntimeException
//     * @return response to the client that something goes wrong
//     */
//    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(value = RuntimeException.class)
//    protected ResponseEntity<String> catchRuntimeException() {
//        return ResponseEntity.badRequest().body(MessageEnum.ERROR_AT_RUNTIME.getErrorMessage());
//    }

    /**
     * Catch InvalidDataAccessResourceUsageException
     * @return response to the client that there are some problems at the DAO layer
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
    protected ResponseEntity<String> catchInvalidDataAccess() {
        return ResponseEntity.badRequest().body(MessageEnum.ERROR_INVALID_DATA_ACCESS.getErrorMessage());
    }
}

