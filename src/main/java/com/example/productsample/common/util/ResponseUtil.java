package com.example.productsample.common.util;

import com.example.productsample.common.response.ErrorCode;
import com.example.productsample.common.response.ErrorResponse;

public class ResponseUtil {

    public static ErrorResponse error(String code, String message) {
        return ErrorResponse.builder().code(code).message(message).build();
    }

    public static ErrorResponse error(ErrorCode errorCode) {
        return ErrorResponse.builder().code(errorCode.getCode()).message(errorCode.getMessage()).build();
    }

}
