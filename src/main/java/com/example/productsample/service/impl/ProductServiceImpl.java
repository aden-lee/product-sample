package com.example.productsample.service.impl;

import com.example.productsample.common.exception.CustomException;
import com.example.productsample.common.response.ErrorCode;
import com.example.productsample.domain.Product;
import com.example.productsample.domain.ProductOption;
import com.example.productsample.dto.ListResponse;
import com.example.productsample.dto.ProductOptionDto;
import com.example.productsample.dto.ProductRequest;
import com.example.productsample.dto.ProductResponse;
import com.example.productsample.repository.mapper.ProductMapper;
import com.example.productsample.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public Object getProduct(long pid) {
        return buildProductInfo(pid);
    }

    @Override
    public Object getAllProduct(String proName, String startCreated, String endCreated, Integer qty, List<Integer> priceList, int page, int size) throws Exception {
        ListResponse<ProductResponse> response = new ListResponse<>();
        if (priceList == null) {
            priceList = new ArrayList<>();
        }
        if (priceList.size() > 2) {
            throw new CustomException(ErrorCode.INVALID_PARAM, "가격");
        }
        List<Product> productList = productMapper.selectProduct(proName, startCreated, endCreated, qty, priceList, getOffset(page, size), size);
        int totalCount = productMapper.selectProductCount(proName, startCreated, endCreated, qty, priceList);
        List<ProductResponse> productResponseList = new ArrayList<>();
        productList.forEach(product -> productResponseList.add(new ProductResponse(product)));

        response.setTotalCount(totalCount);
        response.setData(productResponseList);
        return response;
    }

    @Override
    @Transactional
    public Object saveProduct(ProductRequest request) throws Exception {
        Product product = new Product();
        List<ProductOption> productOptions = new ArrayList<>();
        setProductInfo(product, request);
        product.setCid(request.getCid());
        productMapper.insertProduct(product);

        setProductOptionInfo(product.getPid(), productOptions, request);
        productMapper.insertProductOption(productOptions);
        ProductResponse productResponse = new ProductResponse();
        productResponse.setPid(product.getPid());
        return productResponse;
    }

    private Integer getOffset(Integer page, Integer size) {
        Integer offset;
        if (page != null && size != null) {
            offset = (page - 1) * size;
            if (offset < 0) {
                throw new CustomException(ErrorCode.INVALID_PARAM, "파라메터");
            }
        } else {
            offset = null;
        }
        return offset;
    }

    private ProductResponse buildProductInfo(long pid) {
        ProductResponse productResponse = new ProductResponse();
        Product product = productMapper.selectProductByPId(pid);
        if(Objects.isNull(product)) {
            throw new CustomException(ErrorCode.PRODUCT_NOT_FOUND);
        }
        List<ProductOption> productOptionList = productMapper.selectProductOptionByPId(pid);

        productResponse.setPid(product.getPid());
        productResponse.setCid(product.getCid());
        productResponse.setProName(product.getProName());
        productResponse.setProDesc(product.getProDesc());

        List<ProductOptionDto> resultDto = new ArrayList<>();
        productOptionList.forEach(option ->{
            ProductOptionDto productOptionDto = new ProductOptionDto();
            productOptionDto.setSize(option.getSize());
            productOptionDto.setPrice(option.getPrice());
            productOptionDto.setQty(option.getQty());
            resultDto.add(productOptionDto);
        });
        productResponse.setOpt(resultDto);
        return productResponse;
    }

    private void setProductInfo(Product product, ProductRequest request) throws Exception {
        if (StringUtils.isEmpty(request.getProName())) {
            throw new CustomException(ErrorCode.INVALID_PARAM, "상품명");
        }

        if (StringUtils.isEmpty(request.getProDesc())) {
            throw new CustomException(ErrorCode.INVALID_PARAM, "상품 설명");
        }

        Product productResult = productMapper.selectProductByProductName(request.getProName());
        if(Objects.isNull(productResult)) {
            product.setProName(request.getProName());
            product.setProDesc(request.getProDesc());
        } else {
            throw new CustomException(ErrorCode.PRODUCT_NAME_DUP);
        }
    }

    private void setProductOptionInfo(long pid, List<ProductOption> productOptions, ProductRequest request) {
        request.getOpt().forEach(opt -> {
            validationOption(opt);
            ProductOption productOption = new ProductOption();
            productOption.setPid(pid);
            productOption.setSize(opt.getSize());
            productOption.setQty(opt.getQty());
            productOption.setPrice(opt.getPrice());
            productOptions.add(productOption);
        });
    }

    private void validationOption(ProductOptionDto productOptionDto) {
        if (StringUtils.isEmpty(productOptionDto.getSize())) {
            throw new CustomException(ErrorCode.PRODUCT_INVALID_SIZE);
        }

        if (productOptionDto.getQty() < 1) {
            throw new CustomException(ErrorCode.PRODUCT_INVALID_QTY);
        }

        if (productOptionDto.getPrice() < 100) {
            throw new CustomException(ErrorCode.PRODUCT_INVALID_PRICE);
        }
    }

}
