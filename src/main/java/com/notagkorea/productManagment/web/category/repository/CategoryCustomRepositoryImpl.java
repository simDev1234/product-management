package com.notagkorea.productManagment.web.category.repository;

import com.notagkorea.productManagment.db.entity.Category;
import com.notagkorea.productManagment.db.entity.QCategory;
import com.notagkorea.productManagment.db.entity.QProduct;
import com.notagkorea.productManagment.db.type.Division;
import com.notagkorea.productManagment.util.OrderSpecifierUtils;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class CategoryCustomRepositoryImpl implements CategoryCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public long countCategoryTotalSalesAmount(String categoryCode) {

        QProduct product = QProduct.product;
        QCategory category = QCategory.category;

        Long totalSalesAmount = jpaQueryFactory
                .select(product.salesAmount.sum())
                .from(product)
                .where(product.productId.in(
                        JPAExpressions
                                .select(product.productId)
                                .from(product)
                                .join(product.category, category)
                                .where(product.category.categoryCode.startsWith(categoryCode))
                        )
                ).fetchOne();

        return Objects.isNull(totalSalesAmount) ? 0 : totalSalesAmount;
    }

    @Override
    public long countDivisionCategories(Division division) {

        QCategory category = QCategory.category;

        Long total = jpaQueryFactory
                .select(category.count())
                .from(category)
                .where(category.division.eq(division))
                .fetchOne();

        return Objects.isNull(total) ? 0 : total;
    }

    @Override
    public long countSubDivisionCategories(Division division, String parentCategoryCode) {

        QCategory category = QCategory.category;

        Long total = jpaQueryFactory
                .select(category.count())
                .from(category)
                .where(
                        category.division.eq(division),
                        category.categoryCode.startsWith(parentCategoryCode)
                ).fetchOne();

        return Objects.isNull(total) ? 0 : total;
    }

    @Override
    public Page<Category> getDivisionCategories(Division division, Pageable pageable) {

        QCategory category = QCategory.category;

        List<Category> categories = jpaQueryFactory
                .selectFrom(category)
                .where(category.division.eq(division))
                .orderBy(OrderSpecifierUtils.of(pageable.getSort(), Category.class, "category"))
                .offset(pageable.getPageNumber() - 1)
                .limit(pageable.getPageSize())
                .fetch();

        long total = countDivisionCategories(division);

        return new PageImpl<>(categories, pageable, total);
    }

    @Override
    public Page<Category> getSubDivisionCategories(Division division, String parentCategoryCode, Pageable pageable) {

        QCategory category = QCategory.category;

        long total = countSubDivisionCategories(division, parentCategoryCode);

        List<Category> categories = jpaQueryFactory
                .selectFrom(category)
                .where(
                        category.division.eq(division),
                        category.categoryCode.startsWith(parentCategoryCode)
                )
                .orderBy(OrderSpecifierUtils.of(pageable.getSort(), Category.class, "category"))
                .offset(pageable.getPageNumber() - 1)
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(categories, pageable, total);
    }

}
