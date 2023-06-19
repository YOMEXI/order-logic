package com.app.michellerestaurant.service;

import com.app.michellerestaurant.dto.product.createProductDto;
import com.app.michellerestaurant.dto.product.createProductResponseDto;

import java.util.List;

public interface ProductService {
    createProductResponseDto createProduct(createProductDto createProductDto);
   List<createProductResponseDto> allProduct();
}
