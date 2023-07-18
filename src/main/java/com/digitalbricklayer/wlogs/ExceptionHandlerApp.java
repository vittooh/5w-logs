package com.digitalbricklayer.wlogs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApp {

    private final Logger logger = LoggerFactory.getLogger(ExceptionHandlerApp.class);


    @ExceptionHandler(value = Exception.class)
    ResponseEntity<Object> handle(Exception e) {
        logger.error(e.getMessage());
        e.printStackTrace();

        return ResponseEntity.internalServerError().build();
    }


}
