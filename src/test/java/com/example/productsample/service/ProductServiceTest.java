package com.example.productsample.service;

import com.example.productsample.domain.Product;
import com.example.productsample.domain.ProductOption;
import com.example.productsample.dto.ListResponse;
import com.example.productsample.dto.ProductResponse;
import com.example.productsample.repository.mapper.ProductMapper;
import com.example.productsample.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductMapper productMapper;


    @Test
    void test_001_getAllProductTest() throws Exception {
        List<Product> tempList = new ArrayList<>();
        Product product = new Product();
        product.setCid(1);
        product.setProName("새상품");
        product.setProDesc("상품 설명");
        tempList.add(product);
        when(productMapper.selectProduct(any(), any(), any(), any(), any(), anyInt(), anyInt())).thenReturn(tempList);
        when(productMapper.selectProductCount(any(), any(), any(), any(), any())).thenReturn(2);

        ListResponse<ProductResponse> result = (ListResponse<ProductResponse>) productService.getAllProduct("새상품",null, null, null, null, 1, 10);

        Assertions.assertTrue(result.getTotalCount() > 0);
        Assertions.assertEquals("새상품", result.getData().get(0).getProName());
    }

    @Test
    void test_002_saveProductTest () throws Exception{
        Product product = new Product();
        product.setCid(1);
        product.setProName("새상품2");
        product.setProDesc("상품 설명2");
        productMapper.insertProduct(product);

        List<ProductOption> productOptions = new ArrayList<>();
        ProductOption po = new ProductOption();
        po.setPid(1);
        po.setSize("270");
        po.setQty(5);
        po.setPrice(5000);
        productOptions.add(po);
        productMapper.insertProductOption(productOptions);
    }

}
