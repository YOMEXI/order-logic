package com.app.michellerestaurant.dto.product;

import com.app.michellerestaurant.entity.Category;
import lombok.Data;

@Data
public class createProductResponseDto {
    Long id;
    Integer price;
    String name;
    Category category;

}
