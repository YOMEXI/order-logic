package com.app.michellerestaurant.repository;

import com.app.michellerestaurant.dto.product.createProductResponseDto;
import com.app.michellerestaurant.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
