package com.notagkorea.productManagment.web.product.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notagkorea.productManagment.db.entity.Product;
import com.notagkorea.productManagment.web.category.dto.TopSalesBrand;
import com.notagkorea.productManagment.web.product.dto.SearchProductsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import java.util.List;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void 카테고리_및_브랜드_상품키워드에따른_상품목록_및_상품수_조회() throws JsonProcessingException {

        final String categoryCode = "";
        final String brand = "노태그";
        final String keyword = "원";
        //final Pageable pageable = PageRequest.of(1, 10, Sort.Direction.DESC, "createdAt");
        final SearchProductsRequest request = new SearchProductsRequest(categoryCode, brand, keyword);
        Page<Product> products = productService.searchProducts(request);
        String jsonString = objectMapper.writeValueAsString(products);
        System.out.println(jsonString);

        for (Product product : products.getContent()) {
            System.out.print(product.getProductId() + " : ");
            System.out.println(product.getProductName());
        }

    }

    @Test
    void 판매수량기준_상위N개_브랜드명_및_판매수량_조회() throws JsonProcessingException {

        final int rankLimit = 5;
        final List<TopSalesBrand> topSalesBrands = productService.getTopSalesBrand(rankLimit);
        String jsonString = objectMapper.writeValueAsString(topSalesBrands);
        System.out.println(jsonString);

        for (TopSalesBrand topSalesBrand : topSalesBrands) {
            System.out.print(topSalesBrand.getBrand() + "(");
            System.out.println(topSalesBrand.getTotalSalesAmount() + ")");
        }

    }

}