package com.app.michellerestaurant.dto.product;

import lombok.Data;

@Data
public class createProductDto {
     String name;
     Long categoryId;
     Integer price;
}
