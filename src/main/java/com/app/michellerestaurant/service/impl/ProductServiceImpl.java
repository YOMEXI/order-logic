package com.app.michellerestaurant.service.impl;

import com.app.michellerestaurant.dto.category.createCategoryResponseDto;
import com.app.michellerestaurant.dto.product.createProductDto;
import com.app.michellerestaurant.dto.product.createProductResponseDto;
import com.app.michellerestaurant.entity.Category;
import com.app.michellerestaurant.entity.Product;
import com.app.michellerestaurant.exception.CustomApiException;
import com.app.michellerestaurant.repository.CategoryRepository;
import com.app.michellerestaurant.repository.ProductRepository;
import com.app.michellerestaurant.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public createProductResponseDto createProduct(createProductDto createProductDto) {

       Optional<Category> productCategory = categoryRepository
               .findById(createProductDto.getCategoryId());



       if(productCategory.isEmpty())
           throw new CustomApiException(HttpStatus.BAD_REQUEST,"Category Does not Exists");

       Product newProduct = new Product();
       newProduct.setCategory(productCategory.get());
       newProduct.setName(createProductDto.getName());
       newProduct.setPrice(createProductDto.getPrice());

       productRepository.save(newProduct);

        return modelMapper.map(newProduct, createProductResponseDto.class);
    }

    @Override
    public List<createProductResponseDto> allProduct() {

        List<Product> allProduct = productRepository.findAll();


        var mappedProducts= allProduct.stream()
                .map(product -> modelMapper.map(product, createProductResponseDto.class))
                .collect(Collectors.toList());

        return mappedProducts;
    }
}
