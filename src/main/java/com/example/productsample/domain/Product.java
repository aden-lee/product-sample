package com.example.productsample.domain;


import lombok.*;

@Getter
@Setter
public class Product {
    private long pid;

    private String proName;

    private String proDesc;

    private long cid;

    private String created;

    private String updated;

}
