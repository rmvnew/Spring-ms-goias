package com.company.mscompanies.exceptions;


import com.company.mscompanies.resource.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex){
        return ResponseEntity.status(ex.getHttpStatus()).body(new ErrorDto(ex.getErrorCode().getCode(),ex.getMessage()));
    }

}
