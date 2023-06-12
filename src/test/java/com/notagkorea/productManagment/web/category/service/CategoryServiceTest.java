package com.notagkorea.productManagment.web.category.service;

import com.notagkorea.productManagment.db.entity.Category;
import com.notagkorea.productManagment.db.type.Division;
import com.notagkorea.productManagment.web.category.dto.AddCategoryRequest;
import com.notagkorea.productManagment.web.category.dto.GetCategoryPageRequest;
import com.notagkorea.productManagment.web.category.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

@SpringBootTest
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;


    // 카테고리 코드는 8개의 코드로 구성되며, 각 2자리씩 [대분류][중분류][소분류][세분류]로 나뉘어진다.
    // 카테고리 코드는 분류별로 01~99 까지 등록 가능하다.
    @Test
    void 카테고리등록(){
        final String categoryCode = "04";
        final String categoryName = "가공식품";
        final Division division = Division.DIVISION1;
        final AddCategoryRequest request = new AddCategoryRequest(categoryCode,categoryName,division);
        categoryService.addCategory(request);
    }

    @Test
    void 카테고리조회(){
        final int divisionLevel = 2;
        final String parentCategoryCode = "01";
        final GetCategoryPageRequest request = new GetCategoryPageRequest(divisionLevel, parentCategoryCode);
        final Pageable pageable = PageRequest.of(1, 100000, Sort.Direction.ASC, "categoryName");
        Page<Category> categoryPage = categoryService.getCategoryPage(request, pageable);
        categoryPage.getContent().stream().forEach(category -> {
            System.out.printf("division : %s , code : %s, name : %s\n",
                    category.getDivision().getDivisionName(), category.getCategoryCode(), category.getCategoryName());
        });
    }

    @Test
    void 카테고리판매수량조회(){
        final String categoryCode = "01";
        final long categoryTotalSalesAmount = categoryService.getCategoryTotalSalesAmount(categoryCode);
        System.out.println(categoryTotalSalesAmount);
    }

}