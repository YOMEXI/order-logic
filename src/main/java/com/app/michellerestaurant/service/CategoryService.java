package com.app.michellerestaurant.service;

import com.app.michellerestaurant.dto.category.createCategoryDto;
import com.app.michellerestaurant.dto.category.createCategoryResponseDto;
import com.app.michellerestaurant.entity.Category;

import java.util.List;

public interface CategoryService {
    createCategoryResponseDto createCategory(createCategoryDto categoryDto);

    List<createCategoryResponseDto> allCategory();
}
