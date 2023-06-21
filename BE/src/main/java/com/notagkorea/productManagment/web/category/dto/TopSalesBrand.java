package com.notagkorea.productManagment.web.category.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class TopSalesBrand {

    private String brand;
    private long totalSalesAmount;

    @QueryProjection
    public TopSalesBrand(String brand, long totalSalesAmount) {
        this.brand = brand;
        this.totalSalesAmount = totalSalesAmount;
    }

}
