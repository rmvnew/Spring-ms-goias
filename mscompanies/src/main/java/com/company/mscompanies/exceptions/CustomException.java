package com.company.mscompanies.exceptions;


import com.company.mscompanies.enums.ErrorCode;
import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
    private final HttpStatus httpStatus;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMesage());
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
    }

    public CustomException(ErrorCode errorCode, HttpStatus httpStatus, Throwable reason) {
        super(errorCode.getMesage());
        this.errorCode = errorCode;
        this.httpStatus = errorCode.getHttpStatus();
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
