package com.notagkorea.productManagment.web.category.service;

import com.notagkorea.productManagment.db.entity.Category;
import com.notagkorea.productManagment.db.type.Division;
import com.notagkorea.productManagment.web.category.dto.AddCategoryRequest;
import com.notagkorea.productManagment.web.category.dto.GetCategoryPageRequest;
import com.notagkorea.productManagment.web.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void addCategory(final AddCategoryRequest request) {
        categoryRepository.save(request.toCategory());
    }

    // 전체 or 대/중/소/세 분류별로 조회
    // + 부모 카테고리에 대한 하위 카테고리만 조회
    public Page<Category> getCategoryPage(GetCategoryPageRequest request, Pageable pageable) {

        String parentCategoryCode = request.getParentCategoryCode();
        Division division = Division.of(request.getDivisionLevel());

        return StringUtils.hasText(parentCategoryCode) ?
                categoryRepository.getSubDivisionCategories(division, parentCategoryCode, pageable)
                : categoryRepository.getDivisionCategories(division, pageable);

    }

    // 카테고리별 전체 판매수량
    public long getCategoryTotalSalesAmount(String categoryCode){
        return categoryRepository.countCategoryTotalSalesAmount(categoryCode);
    }

}
