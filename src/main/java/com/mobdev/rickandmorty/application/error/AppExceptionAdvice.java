package com.mobdev.rickandmorty.application.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AppExceptionAdvice {

    @ExceptionHandler(value = CharacterNotFoundException.class)
    public ResponseEntity<Map<String,String>> handlerUserNotFoundException(){

        Map<String,String> map = new HashMap<>();
        map.put("message","Character not found");
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }
}
