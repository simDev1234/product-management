package com.notagkorea.productManagment.web.product.repository;

import com.notagkorea.productManagment.db.entity.Product;
import com.notagkorea.productManagment.web.category.dto.TopSalesBrand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductCustomRepository {

    long countSearchProductsResult(String categoryCode,
                                   String brand, String productNameKeyword);

    Page<Product> searchProductsBy(String categoryCode, String brand, String productNameKeyword,
                                   Pageable pageable);

    List<TopSalesBrand> getTopSalesBrandPage(int rankLimit);

}
