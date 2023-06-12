package com.notagkorea.productManagment.web.category.repository;

import com.notagkorea.productManagment.db.entity.Category;
import com.notagkorea.productManagment.db.type.Division;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryCustomRepository {

    long countCategoryTotalSalesAmount(String categoryCode);

    long countDivisionCategories(Division division);

    long countSubDivisionCategories(Division division, String parentCategoryCode);

    Page<Category> getDivisionCategories(Division division, Pageable pageable);

    Page<Category> getSubDivisionCategories(Division division, String parentCategoryCode, Pageable pageable);

}
