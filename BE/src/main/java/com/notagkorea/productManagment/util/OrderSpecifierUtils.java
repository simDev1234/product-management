package com.notagkorea.productManagment.util;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import org.springframework.data.domain.Sort;

public class OrderSpecifierUtils {

    public static <T> OrderSpecifier[] of(Sort sort, Class<T> classType, String variable) {

        return sort.stream().map(order -> {
            String property = order.getProperty();
            Order direction = order.isAscending() ? Order.ASC : Order.DESC;
            PathBuilder<T> orderByExpression = new PathBuilder<>(classType, variable);
            return new OrderSpecifier(direction, orderByExpression.get(property));
        }).toArray(OrderSpecifier[]::new);

    }

}
