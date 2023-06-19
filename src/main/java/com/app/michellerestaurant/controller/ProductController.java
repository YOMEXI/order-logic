package com.app.michellerestaurant.controller;

import com.app.michellerestaurant.dto.product.createProductDto;
import com.app.michellerestaurant.dto.product.createProductResponseDto;
import com.app.michellerestaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/")
    public createProductResponseDto createProduct (@RequestBody createProductDto product){

        return productService.createProduct(product);
    }

    @GetMapping("/")
    public List<createProductResponseDto> allProduct (@RequestBody createProductDto product){
        return productService.allProduct();
    }


}
