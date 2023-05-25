package com.example.productsample.repository.mapper;

import com.example.productsample.domain.Product;
import com.example.productsample.domain.ProductOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper {
    void insertProduct(@Param("param") Product product);

    void insertProductOption(@Param("productOptions") List<ProductOption> productOptions);

    Product selectProductByPId (@Param("pid") long pid);

    List<ProductOption> selectProductOptionByPId (@Param("pid") long pid);

    Product selectProductByProductName(@Param("proName") String proName);

    List<Product> selectProduct(@Param("proName") String proName, @Param("startCreated") String startCreated, @Param("endCreated") String endCreated, @Param("qty") Integer qty, @Param("priceList") List<Integer> priceList, @Param("offset") Integer offset, @Param("size") int size);

    int selectProductCount(@Param("proName") String proName, @Param("startCreated") String startCreated, @Param("endCreated") String endCreated, @Param("qty") Integer qty, @Param("priceList") List<Integer> priceList);
}
