package com.app.michellerestaurant.controller;

import com.app.michellerestaurant.dto.category.createCategoryDto;
import com.app.michellerestaurant.dto.category.createCategoryResponseDto;
import com.app.michellerestaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/")
    public createCategoryResponseDto createCategory(@RequestBody createCategoryDto categoryDto){

        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("/")
    public List<createCategoryResponseDto> getAllCategory(){
        return categoryService.allCategory();
    }



}
