package com.example.productsample.domain;

import lombok.*;


@Getter
@Setter
public class ProductOption {
    private long pid; // 제품아이디
    private String size; // 제품 사이즈
    private int qty; // 재고
    private int price; // 제품가격
}
