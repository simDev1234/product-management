package com.notagkorea.productManagment.web.product.controller;

import com.notagkorea.productManagment.db.entity.Product;
import com.notagkorea.productManagment.web.category.dto.TopSalesBrand;
import com.notagkorea.productManagment.web.product.dto.SearchProductsRequest;
import com.notagkorea.productManagment.web.product.service.ProductService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/products")
@Api(tags = "상품 관리 API")
public class ProductController {

    private final ProductService productService;

    // 상품 검색 : 카테고리 | 브랜드 | (상품)키워드에 따른 상품 검색
    @GetMapping("/search")
    public ResponseEntity<Page<Product>> productsSearch(SearchProductsRequest request){

        Page<Product> products = productService.searchProducts(request);

        return ResponseEntity.ok(products);
    }

    // 가장 많이 판매된 상위 N개 브랜드명과 판매 수량
    @GetMapping("/top-brand")
    public ResponseEntity<List<TopSalesBrand>> topBrandSalesQuantities(@RequestParam int rankLimit){

        List<TopSalesBrand> topSalesBrands = productService.getTopSalesBrand(rankLimit);

        return ResponseEntity.ok(topSalesBrands);
    }

}
