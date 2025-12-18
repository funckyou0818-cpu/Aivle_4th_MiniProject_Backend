package com.example.aivle_4th_MiniProject_team19.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResponse illegalExceptionHandler(IllegalArgumentException e) {
        log.error("ExceptionHandler : {}", e);

        return new ErrorResponse("BAD", e.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ErrorResponse bookNotFoundExceptionHandler(BookNotFoundException e) {
        log.error("ExceptionHandler : {}", e);

        return new ErrorResponse("BookNotFound", e.getMessage());
    }
}
