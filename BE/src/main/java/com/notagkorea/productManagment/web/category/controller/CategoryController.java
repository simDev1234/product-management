package com.notagkorea.productManagment.web.category.controller;

import com.notagkorea.productManagment.db.entity.Category;
import com.notagkorea.productManagment.web.category.dto.GetCategoryPageRequest;
import com.notagkorea.productManagment.web.category.service.CategoryService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/categories")
@Api(tags = "카테고리 관리 API")
public class CategoryController {

    private final CategoryService categoryService;

    // 카테고리 분류별 목록 조회 : 분류별로 카테고리 조회가 필요함.
    // * 요청값 예시 : /categories?divisionLevel=1&parentCategoryCode=01&page=1&size=10&sort=categoryCode,asc
    @GetMapping
    public ResponseEntity<Page<Category>> categoryList(GetCategoryPageRequest request){

        Pageable pageable = PageRequest.of(1, Integer.MAX_VALUE, Sort.Direction.ASC, "categoryName");

        Page<Category> categoryPage = categoryService.getCategoryPage(request, pageable);

        return ResponseEntity.ok(categoryPage);
    }

    // 카테고리별 전체 판매수량
    @GetMapping("/sales")
    public ResponseEntity categoryTotalSalesAmount(@RequestParam String categoryCode){

        long totalSalesAmount = categoryService.getCategoryTotalSalesAmount(categoryCode);

        return ResponseEntity.ok(totalSalesAmount);
    }

}
