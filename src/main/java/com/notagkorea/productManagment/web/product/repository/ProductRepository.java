package com.notagkorea.productManagment.web.product.repository;

import com.notagkorea.productManagment.db.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, ProductCustomRepository {



}
