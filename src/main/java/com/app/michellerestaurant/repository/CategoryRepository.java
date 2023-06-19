package com.app.michellerestaurant.repository;

import com.app.michellerestaurant.entity.Category;
import com.app.michellerestaurant.enums.category.CategoryType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<Category> findByName(String name);



}
