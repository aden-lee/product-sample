package com.example.productsample.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;


@Getter
@Setter
@NoArgsConstructor
@Schema(description = "상품 등록 요청 DTO")
public class ProductRequest {

    @Schema(description = "상품 이름", example = "무신사 스탠다드")
    private String proName;

    @Schema(description = "상품 설명", example = "깔끔한 매치")
    private String proDesc;

    @Schema(description = "회사 ID", example = "1")
    private long cid;

    private List<ProductOptionDto> opt;
}
