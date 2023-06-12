package com.notagkorea.productManagment.web.category.repository;

import com.notagkorea.productManagment.db.entity.Category;
import com.notagkorea.productManagment.db.entity.QCategory;
import com.notagkorea.productManagment.db.entity.QProduct;
import com.notagkorea.productManagment.db.type.Division;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
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

        Long totalSalesAmount = jpaQueryFactory
                .select(product.salesAmount.sum())
                .from(product)
                .join(product.category)
                .where(product.category.categoryCode.startsWith(categoryCode))
                .fetchOne();

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
                .orderBy(getOrderSpecifier(pageable.getSort()))
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
                .orderBy(getOrderSpecifier(pageable.getSort()))
                .offset(pageable.getPageNumber() - 1)
                .limit(pageable.getPageSize())
                .fetch();

        return new PageImpl<>(categories, pageable, total);
    }

    private OrderSpecifier[] getOrderSpecifier(Sort sort) {

        return sort.stream().map(order -> {
            String property = order.getProperty();
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            PathBuilder<Category> orderByExpression = new PathBuilder<>(Category.class, "category");
            return new OrderSpecifier(direction, orderByExpression.get(property));
        }).toArray(OrderSpecifier[]::new);

    }

}
