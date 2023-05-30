package com.example.productsample.domain;


import lombok.*;

@Getter
@Setter
public class Product {
    private long pid; // 제품아이디

    private String proName; // 제품 이름

    private String proDesc; //제품 설명

    private long cid; // 제조사

    private String created; // 등록일자

    private String updated; // 업데이트 일자

}
