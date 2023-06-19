package com.app.michellerestaurant.dto.order;

import lombok.Data;

@Data
public class OrderItemDto {
    private Integer quantity;
    private Long productId;
}
