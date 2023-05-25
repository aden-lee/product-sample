package com.example.productsample.domain;

import lombok.*;


@Getter
@Setter
public class ProductOption {
    private long pid;
    private String size;
    private int qty;
    private int price;
}
