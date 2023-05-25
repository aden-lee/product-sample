package com.example.productsample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Schema(description = "상품 옵션")
public class ProductOptionDto {
    @Schema(description = "상품 사이즈", example = "270")
    private String size;
    @Schema(description = "상품 재고수량", example = "50")
    private int qty;
    @Schema(description = "상품 가격", example = "45000")
    private int price;
}
