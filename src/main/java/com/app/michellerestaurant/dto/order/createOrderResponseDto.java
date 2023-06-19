package com.app.michellerestaurant.dto.order;

import com.app.michellerestaurant.entity.OrderItem;
import com.app.michellerestaurant.enums.order.OrderStatus;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class createOrderResponseDto {
    private UUID id;
    private  Integer phone;
    private String address;
    private Integer totalPrice;
    private OrderStatus status;
    private List<OrderItem> orderItems;
}
