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
    PRODUCT_ALREADY_REGISTERED(100,"This product is already registered.", INTERNAL_SERVER_ERROR),
   INVALID_TOKEN(101,"This token is invalid", INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;

}
