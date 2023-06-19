package com.app.michellerestaurant.controller;

import com.app.michellerestaurant.dto.order.createOrderDto;
import com.app.michellerestaurant.dto.order.createOrderResponseDto;
import com.app.michellerestaurant.dto.product.createProductDto;
import com.app.michellerestaurant.dto.product.createProductResponseDto;
import com.app.michellerestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/")
    public createOrderResponseDto createOrder (@RequestBody createOrderDto order){

        return orderService.createOrder(order);
    }

    @GetMapping("/")
    public List<createOrderResponseDto> getOrder (){

        return orderService.allOrders();
    }
}
