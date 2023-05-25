package com.example.productsample.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(@Value("${springdoc.api-docs.version}") String springdocVersion) {
        Info info = new Info()
                .title("Java Backend 과제")
                .version(springdocVersion)
                .description("상품 조회 등록 샘플");

        return new OpenAPI()
                .components(new Components())
                .info(info);
    }
}