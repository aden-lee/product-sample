package com.example.productsample.common.response;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    BAD_REQUEST(HttpStatus.BAD_REQUEST, "400", HttpStatus.BAD_REQUEST.getReasonPhrase()),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "401", HttpStatus.UNAUTHORIZED.getReasonPhrase()),
    FORBIDDEN(HttpStatus.FORBIDDEN, "403", HttpStatus.FORBIDDEN.getReasonPhrase()),
    NOT_FOUND(HttpStatus.NOT_FOUND, "404", HttpStatus.NOT_FOUND.getReasonPhrase()),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "500", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase()),

    // BAD_REQUEST
    INVALID_PARAM(HttpStatus.BAD_REQUEST, "400001", "%s (이)가 유효하지 않습니다."),

    PRODUCT_INVALID_QTY(HttpStatus.NOT_FOUND, "400002", "수량이 유효하지 않습니다."),
    PRODUCT_INVALID_PRICE(HttpStatus.NOT_FOUND, "400003", "가격 유효하지 않습니다."),
    PRODUCT_INVALID_SIZE(HttpStatus.NOT_FOUND, "400004", "사이즈가 유효하지 않습니다."),

    PRODUCT_NAME_DUP(HttpStatus.BAD_REQUEST, "400002", "상품명이 중복 되었습니다."),

    PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "404001", "상품을 찾을 수 없습니다.");



    private final HttpStatus status;
    private final String code;
    private final String message;

    ErrorCode(HttpStatus status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}