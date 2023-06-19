package com.app.michellerestaurant.dto.category;

import com.app.michellerestaurant.enums.category.CategoryType;
import lombok.Data;

@Data
public class createCategoryResponseDto {

    Long id;
    CategoryType name;
}
