package com.app.michellerestaurant.service;

import com.app.michellerestaurant.dto.order.createOrderDto;
import com.app.michellerestaurant.dto.order.createOrderResponseDto;

import java.util.List;

public interface OrderService {
    createOrderResponseDto createOrder(createOrderDto createOrderDto);
    List <createOrderResponseDto> allOrders();
}
