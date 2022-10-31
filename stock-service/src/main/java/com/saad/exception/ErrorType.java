package com.saad.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {
    INTERNAL_ERROR(2000, "Internal Server Error", INTERNAL_SERVER_ERROR),
    BAD_REQUEST_ERROR(2001, "Invalid Parameter Error", BAD_REQUEST),
    LOGIN_ERROR_001(190, "Kullanıcı adı ya da şifre hatalı", INTERNAL_SERVER_ERROR),
    INVALID_TOKEN(200,"Invalid token.", INTERNAL_SERVER_ERROR),
    INVALID_ID(202,"Product id is null.", INTERNAL_SERVER_ERROR),
   PRODUCT_NOT_FOUND(201,"The product to be updated could not be found.", INTERNAL_SERVER_ERROR);


    private int code;
    private String message;
    HttpStatus httpStatus;

}
