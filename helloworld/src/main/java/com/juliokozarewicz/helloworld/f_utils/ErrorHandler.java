package com.juliokozarewicz.helloworld.f_utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception error) {

        // get error itens
        String errorMessage = error.getMessage();
        errorMessage = errorMessage.substring(1, errorMessage.length() - 1);
        Map<String, Object> errorMap = new LinkedHashMap<>();
        String[] keyValuePairs = errorMessage.split(", ");
        for (String line : keyValuePairs) {
            String[] KeyIten = line.split("=");
            errorMap.put(KeyIten[0], KeyIten[1]);
        }

        String customError = (String) errorMap.get("customError");
        String errorCode = (String) errorMap.get("errorCode");
        String errorMessageDetail = (String) errorMap.get("message");

        if (
            "true".equals(customError) && 
            errorCode != null && 
            !errorCode.isEmpty() && 
            errorMessageDetail != null && 
            !errorMessageDetail.isEmpty()
        ) {

            Map<String, Object> errorResponse = new LinkedHashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("statusCode", Integer.parseInt(errorCode));
            errorResponse.put("message", errorMessageDetail);

            return ResponseEntity
            .status(Integer.parseInt(errorCode))
            .body(errorResponse);

        } else {

            return ResponseEntity
            .status(500)
            .body(error.getMessage());

        }

    }

}
