package com.notagkorea.productManagment.web.product.service;

import com.notagkorea.productManagment.db.entity.Product;
import com.notagkorea.productManagment.web.category.dto.TopSalesBrand;
import com.notagkorea.productManagment.web.product.dto.SearchProductsRequest;
import com.notagkorea.productManagment.web.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> searchProducts(SearchProductsRequest request) {

        return productRepository.searchProductsBy(request.getCategoryCode(),
                request.getBrand(), request.getKeyword(), request.toPageable());

    }

    public List<TopSalesBrand> getTopSalesBrand(int rankLimit) {

        return productRepository.getTopSalesBrandPage(rankLimit);

    }

}
