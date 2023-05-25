package com.example.productsample.common.exception;

import com.example.productsample.common.response.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private HttpStatus status;
    private String code;

    public CustomException(ErrorCode responseCode) {
        super(responseCode.getMessage());
        this.code = responseCode.getCode();
        this.status = responseCode.getStatus();
    }

    public CustomException(String message, ErrorCode responseCode) {
        super(message);
        this.code = responseCode.getCode();
        this.status = responseCode.getStatus();
    }

    public CustomException(ErrorCode responseCode, Object... params) {
        super(String.format(responseCode.getMessage(), params));
        this.code = responseCode.getCode();
        this.status = responseCode.getStatus();
    }

    public CustomException(ErrorCode responseCode, Throwable cause) {
        super(cause);
        this.code = responseCode.getCode();
        this.status = responseCode.getStatus();
    }

}
