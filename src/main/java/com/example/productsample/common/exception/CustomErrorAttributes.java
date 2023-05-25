package com.example.productsample.common.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        Map<String, Object> customErrorAttributes = new HashMap<>();
        customErrorAttributes.put("resultCode", errorAttributes.get("status"));
        customErrorAttributes.put("resultMessage", errorAttributes.get("message"));

        return customErrorAttributes;
    }
}