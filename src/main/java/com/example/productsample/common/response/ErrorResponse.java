package com.example.productsample.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class ErrorResponse implements Serializable {
    private String code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String message;
}
