package com.notagkorea.productManagment.web.product.dto;

import com.notagkorea.productManagment.util.KoreanString;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@NoArgsConstructor
@Getter
public class SearchProductsRequest {

    private String categoryCode;
    private String brand;
    private String keyword;
    private Pageable pageable;

    public SearchProductsRequest(String categoryCode, String brand, String keyword, Pageable pageable) {
        this.categoryCode = categoryCode;
        this.brand = KoreanString.toUTF8String(brand);
        this.keyword = KoreanString.toUTF8String(keyword);
        this.pageable = pageable;
    }

    public SearchProductsRequest(String categoryCode, String brand, String keyword) {
        this(categoryCode, brand, keyword, PageRequest.of(1, 10, Sort.Direction.DESC, "createdAt"));
    }

}
