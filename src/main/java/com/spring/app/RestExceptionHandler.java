package com.spring.app;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exception handler
 * Return a message to client to explain problem
 *
 * @author Lyubov Ruzanova
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<Object> catchIllegal(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Oops! Something went wrong, please contact Lyubov \n Telegram: @akelanova";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(value = RuntimeException.class)
    protected ResponseEntity<Object> catchRuntimeException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Oops! Something went wrong, please contact Lyubov \n Telegram: @akelanova";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class)
    protected ResponseEntity<Object> catchInvalidDataAccess(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Oops! Something went wrong, please contact Lyubov \n Telegram: @akelanova";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }



}

