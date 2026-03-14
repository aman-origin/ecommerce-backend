package com.aman.ecommerce.product.repository;

import com.aman.ecommerce.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}