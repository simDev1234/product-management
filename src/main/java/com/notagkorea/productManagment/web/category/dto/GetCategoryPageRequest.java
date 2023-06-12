package com.notagkorea.productManagment.web.category.dto;

import com.mysema.commons.lang.Assert;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class GetCategoryPageRequest {

    private int divisionLevel;
    private String parentCategoryCode;

    public GetCategoryPageRequest(int divisionLevel, String parentCategoryCode) {

        Assert.isTrue(divisionLevel >= 1 && divisionLevel <= 4, "분류 레벨은 1 ~ 4 사이여야 합니다.");

        if (StringUtils.hasText(parentCategoryCode)) {
            Assert.isTrue(parentCategoryCode.matches("^[0-9]{2,8}$"), "카테고리 코드는 2글자 이상 8글자 이하의 숫자여야 합니다.");
            Assert.isTrue(parentCategoryCode.length() < divisionLevel * 2, "상위 카테고리 코드 길이는 하위 카테고리 코드 길이 보다 작아야 합니다.");
        } else {
            parentCategoryCode = "";
        }

        this.divisionLevel = divisionLevel;
        this.parentCategoryCode = parentCategoryCode;
    }
}
