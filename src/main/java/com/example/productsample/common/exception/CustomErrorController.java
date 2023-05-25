package com.example.productsample.common.exception;

import com.example.productsample.common.response.ErrorResponse;
import com.example.productsample.common.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller
public class CustomErrorController extends BasicErrorController {

    public CustomErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, serverProperties.getError(), errorViewResolvers);
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);

        Map<String, Object> body = this.getErrorAttributes(request, this.getErrorAttributeOptions(request, MediaType.ALL));

        ErrorResponse errorResponse = ResponseUtil.error(
                body.get("status").toString(),
                Objects.isNull(body.get("message")) ? body.get("error").toString() : body.get("message").toString());

        return new ResponseEntity(errorResponse, status);
    }
}
