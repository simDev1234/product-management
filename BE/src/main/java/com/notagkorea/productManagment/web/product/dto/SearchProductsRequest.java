package com.notagkorea.productManagment.web.product.dto;

import com.notagkorea.productManagment.global.page.CustomPage;
import com.notagkorea.productManagment.util.KoreanString;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchProductsRequest extends CustomPage {

    private String categoryCode;
    private String brand;
    private String keyword;

    public SearchProductsRequest(int page, int size, String orderBy, String orderDir, String categoryCode, String brand, String keyword) {
        super(page, size, orderBy, orderDir);
        this.categoryCode = categoryCode;
        this.brand = KoreanString.toUTF8String(brand);
        this.keyword = KoreanString.toUTF8String(keyword);
    }

    public SearchProductsRequest(String categoryCode, String brand, String keyword) {
        super(1, 10, "createdAt", "DESC");
        this.categoryCode = categoryCode;
        this.brand = KoreanString.toUTF8String(brand);
        this.keyword = KoreanString.toUTF8String(keyword);
    }

    public SearchProductsRequest() {
        super(1, 10, "createdAt", "DESC");
        this.categoryCode = "";
        this.brand = "";
        this.keyword = "";
    }

}
