package com.notagkorea.productManagment.web.category.repository;

import com.notagkorea.productManagment.db.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String>, CategoryCustomRepository {

}
