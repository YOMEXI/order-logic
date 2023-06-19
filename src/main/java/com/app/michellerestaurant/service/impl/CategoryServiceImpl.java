package com.app.michellerestaurant.service.impl;

import com.app.michellerestaurant.dto.category.createCategoryDto;
import com.app.michellerestaurant.dto.category.createCategoryResponseDto;
import com.app.michellerestaurant.entity.Category;
import com.app.michellerestaurant.exception.CustomApiException;
import com.app.michellerestaurant.repository.CategoryRepository;
import com.app.michellerestaurant.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public createCategoryResponseDto createCategory(createCategoryDto categoryDto) {

        var ifCategoryExist = categoryRepository.findByName(categoryDto.getName());


        if(ifCategoryExist.isPresent())
            throw new CustomApiException(HttpStatus.BAD_REQUEST,"Category already Exists");

        var newCategory = new Category();

        newCategory.setName(categoryDto.getName());
        categoryRepository.save(newCategory);

        return modelMapper.map(newCategory, createCategoryResponseDto.class);
    }

    @Override
    public List<createCategoryResponseDto> allCategory() {

        List<Category>  allCategories = categoryRepository.findAll();
        Type listType = new TypeToken<List<createCategoryResponseDto>>(){}.getType();

        return modelMapper.map(allCategories,listType);
    }
}
