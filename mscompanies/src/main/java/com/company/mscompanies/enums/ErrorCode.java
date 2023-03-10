package com.company.mscompanies.enums;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    USER_NOT_FOUND(100, "Usuário não encontrado",HttpStatus.NOT_FOUND),
    USER_ALREADY_REGISTERED(101, "Usuário já cadastrado!",HttpStatus.BAD_REQUEST),
    EMAIL_ALREADY_REGISTERED(102, "E-mail já cadastrado",HttpStatus.BAD_REQUEST),
    INVALID_CNPJ(200, "Cnpj informado é inválido!",HttpStatus.BAD_REQUEST),
    COMPANY_ALREADY_REGISTERED(201, "Empresa já cadastrada!",HttpStatus.BAD_REQUEST);

    private final int code;
    private final String mesage;

    private final HttpStatus httpStatus;

    ErrorCode(int code, String mesage, HttpStatus httpStatus) {
        this.code = code;
        this.mesage = mesage;
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMesage() {
        return mesage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
