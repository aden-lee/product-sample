package com.example.productsample.controller;

import com.example.productsample.dto.ProductRequest;
import com.example.productsample.service.ProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "상품", description = "상품 API")
@RestController
@RequestMapping("/api/v1/product/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public Object getProduct(
            @Parameter(description = "상품명", example = "에어조단") @RequestParam(value = "proName", required = false) String proName,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @Parameter(description = "등록일자 시작", example = "2023-05-25") @RequestParam(value = "startCreated", required = false) String startCreated,
            @DateTimeFormat(pattern = "yyyy-MM-dd") @Parameter(description = "등록일자 종료", example = "2023-05-26") @RequestParam(value = "endCreated", required = false) String endCreated,
            @Parameter(description = "재고", example = "50") @RequestParam(value = "qty", required = false) Integer qty,
            @Parameter(description = "가격", example = "[30000,40000]") @RequestParam(value = "price", required = false) List<Integer> price,
            @Parameter(description = "페이지", example = "1") @RequestParam(value = "page") int page,
            @Parameter(description = "사이즈", example = "10") @RequestParam(value = "size") int size) throws Exception {
        return productService.getAllProduct(proName, startCreated, endCreated, qty, price, page, size);
    }

    @GetMapping(value = "{pid}")
    public Object getProduct(@PathVariable("pid") long pid) throws Exception {
        return productService.getProduct(pid);
    }

    @PostMapping(value = "")
    public Object saveProduct(@RequestBody ProductRequest request) throws Exception{
        return productService.saveProduct(request);
    }
}
