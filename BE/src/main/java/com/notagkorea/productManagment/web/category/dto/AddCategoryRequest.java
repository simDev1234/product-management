package com.notagkorea.productManagment.web.category.dto;

import com.mysema.commons.lang.Assert;
import com.notagkorea.productManagment.db.entity.Category;
import com.notagkorea.productManagment.db.type.Division;
import com.notagkorea.productManagment.util.KoreanString;
import lombok.Getter;

@Getter
public class AddCategoryRequest {

    private final String categoryName;
    private final String categoryCode;
    private final Division division;

    public AddCategoryRequest(final String categoryCode, final String categoryName, final Division division) {
        Assert.hasText(categoryCode, "카테고리 코드는 필수입니다.");
        Assert.isTrue(categoryCode.matches("^[0-9]{2,8}$"), "카테고리 코드는 2글자 이상 8글자 이하의 숫자여야 합니다.");
        Assert.hasText(categoryName, "카테고리명은 필수입니다.");
        this.categoryCode = categoryCode;
        this.categoryName = KoreanString.toUTF8String(categoryName);
        this.division = division;
    }

    public Category toCategory(){
        return Category.builder()
                .categoryName(this.categoryName)
                .categoryCode(this.categoryCode)
                .division(this.division)
                .build();
    }

}
