package com.leyou.commom.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //拦截所有加了controller注解的类
public class CommonExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> HandleException(RuntimeException e){
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
