package com.example.productsample.service;

import com.example.productsample.dto.ProductRequest;

import java.util.List;

public interface ProductService {
    Object saveProduct(ProductRequest request) throws Exception;

    Object getProduct(long pid) throws Exception;

    Object getAllProduct(String proName, String startCreated, String endCreated, Integer qty, List<Integer> price, int page, int size) throws Exception;

}
