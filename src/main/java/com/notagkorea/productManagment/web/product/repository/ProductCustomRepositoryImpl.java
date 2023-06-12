package com.notagkorea.productManagment.web.product.repository;

import com.notagkorea.productManagment.db.entity.Product;
import com.notagkorea.productManagment.db.entity.QCategory;
import com.notagkorea.productManagment.db.entity.QProduct;
import com.notagkorea.productManagment.util.OrderSpecifierUtils;
import com.notagkorea.productManagment.web.category.dto.QTopSalesBrand;
import com.notagkorea.productManagment.web.category.dto.TopSalesBrand;
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
public class ProductCustomRepositoryImpl implements ProductCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    // 판매수량 기준 상위 N번째의 브랜드명/판매수량 반환
    @Override
    public List<TopSalesBrand> getTopSalesBrandPage(int rankLimit){

        QProduct product = QProduct.product;

        List<TopSalesBrand> topSalesBrands = jpaQueryFactory
                .select(new QTopSalesBrand(
                        product.brand,
                        product.salesAmount.sum().as("totalSalesAmount")
                ))
                .from(product)
                .groupBy(product.brand)
                .orderBy(product.salesAmount.sum().desc())
                .offset(0)
                .limit(rankLimit)
                .fetch();

        return topSalesBrands;
    }

    // 상품 검색 결과 갯수 : 카테고리 | 브랜드명 | (상품)키워드에 따른 상품 검색
    @Override
    public long countSearchProductsResult(String categoryCode,
                                          String brand, String productNameKeyword) {

        QProduct product = QProduct.product;
        QCategory category = QCategory.category;

        Long total = jpaQueryFactory
                .select(product.count())
                .from(product)
                .join(product.category, category)
                .where(
                        product.category.categoryCode.startsWith(categoryCode),
                        product.brand.containsIgnoreCase(brand),
                        product.productName.containsIgnoreCase(productNameKeyword)
                ).distinct().fetchOne();

        return Objects.isNull(total) ? 0 : total;
    }

    // 상품 검색 결과 목록 : 카테고리 | 브랜드명 | (상품)키워드에 따른 상품 검색
    @Override
    public Page<Product> searchProductsBy(String categoryCode,
                                          String brand, String productNameKeyword,
                                          Pageable pageable){

        QProduct product = QProduct.product;
        QCategory category = QCategory.category;

        List<Product> products = jpaQueryFactory
                .selectFrom(product)
                .join(product.category, category)
                .fetchJoin()
                .where(
                        product.category.categoryCode.startsWith(categoryCode),
                        product.brand.contains(brand),
                        product.productName.containsIgnoreCase(productNameKeyword)
                )
                .orderBy(OrderSpecifierUtils.of(pageable.getSort(), Product.class, "product"))
                .offset(pageable.getPageNumber() - 1)
                .limit(pageable.getPageSize())
                .distinct()
                .fetch();

        long total = countSearchProductsResult(categoryCode, brand, productNameKeyword);

        return new PageImpl<>(products, pageable, total);
    }

}
