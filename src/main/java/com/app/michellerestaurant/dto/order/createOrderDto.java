package com.app.michellerestaurant.dto.order;

import com.app.michellerestaurant.entity.OrderItem;
import com.app.michellerestaurant.enums.order.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class createOrderDto {
    private  Integer phone;
    private String address;
    private Integer totalPrice;
    private List<OrderItemDto> order_items;
}
