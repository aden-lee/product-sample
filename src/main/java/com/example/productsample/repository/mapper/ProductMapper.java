package com.example.productsample.repository.mapper;

import com.example.productsample.domain.Product;
import com.example.productsample.domain.ProductOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insertProduct(@Param("param") Product product); //제품 정보 등록

    void insertProductOption(@Param("productOptions") List<ProductOption> productOptions); // 제품 옵션 등록

    Product selectProductByPId (@Param("pid") long pid); // 제품 아이디로 검색

    List<ProductOption> selectProductOptionByPId (@Param("pid") long pid); //옵션테이블에서 제품아이디로 검색

    Product selectProductByProductName(@Param("proName") String proName); // 제품 이름으로 검색

    //제품 검색
    List<Product> selectProduct(@Param("proName") String proName, @Param("startCreated") String startCreated, @Param("endCreated") String endCreated, @Param("qty") Integer qty, @Param("priceList") List<Integer> priceList, @Param("offset") Integer offset, @Param("size") int size);

    //제품 검색 토탈 count
    int selectProductCount(@Param("proName") String proName, @Param("startCreated") String startCreated, @Param("endCreated") String endCreated, @Param("qty") Integer qty, @Param("priceList") List<Integer> priceList);
}
