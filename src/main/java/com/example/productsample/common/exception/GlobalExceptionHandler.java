package com.example.productsample.common.exception;

import com.example.productsample.common.response.ErrorCode;
import com.example.productsample.common.response.ErrorResponse;
import com.example.productsample.common.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({Exception.class, RuntimeException.class})
    public Object handleAllException(Exception ex, WebRequest request) {
        log.error("handleException", ex);

        ErrorResponse result = ResponseUtil.error(ErrorCode.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());

        return super.handleExceptionInternal(ex, result, new HttpHeaders(), ErrorCode.INTERNAL_SERVER_ERROR.getStatus(), request);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public Object handleAccessDeniedException(Exception ex, WebRequest request) {
        log.error("handleAccessDeniedException", ex);

        ErrorResponse result = ResponseUtil.error(ErrorCode.FORBIDDEN.getCode(), ex.getMessage());

        return super.handleExceptionInternal(ex, result, new HttpHeaders(), ErrorCode.FORBIDDEN.getStatus(), request);
    }

    @ExceptionHandler(CustomException.class)
    public Object handleCustomException(CustomException ex, WebRequest request) {
        log.error("handleCustomException", ex);

        ErrorResponse result = ResponseUtil.error(ex.getCode(), ex.getMessage());

        return super.handleExceptionInternal(ex, result, new HttpHeaders(), ex.getStatus(), request);
    }

}