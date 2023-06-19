package com.app.michellerestaurant.service.impl;

import com.app.michellerestaurant.dto.category.createCategoryResponseDto;
import com.app.michellerestaurant.dto.order.createOrderDto;
import com.app.michellerestaurant.dto.order.createOrderResponseDto;
import com.app.michellerestaurant.dto.product.createProductResponseDto;
import com.app.michellerestaurant.entity.Order;
import com.app.michellerestaurant.entity.OrderItem;
import com.app.michellerestaurant.enums.order.OrderStatus;
import com.app.michellerestaurant.repository.OrderItemRepository;
import com.app.michellerestaurant.repository.OrderRepository;
import com.app.michellerestaurant.repository.ProductRepository;
import com.app.michellerestaurant.service.OrderService;
import com.app.michellerestaurant.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public createOrderResponseDto createOrder(createOrderDto createOrderDto) {


       var myorderedItems = createOrderDto.getOrder_items().stream()
                .map(orderItem -> {
                    System.out.println(orderItem.getProductId());
                    var getProduct = productRepository
                            .findById(orderItem.getProductId()).get();

                    var orderedItems = new OrderItem();
                    orderedItems.setQuantity(orderItem.getQuantity());
                    orderedItems.setProducts((getProduct));


                    return orderItemRepository.save(orderedItems);
                }).collect(Collectors.toList());

        Order newOrder = new Order();
        newOrder.setOrderItems(myorderedItems);
        newOrder.setAddress(createOrderDto.getAddress());
        newOrder.setPhone(createOrderDto.getPhone());
        newOrder.setTotalPrice(createOrderDto.getTotalPrice());
        newOrder.setStatus(OrderStatus.PENDING);


        orderRepository.save(newOrder);

        return  modelMapper.map(newOrder, createOrderResponseDto.class);
    }

    @Override
    public List<createOrderResponseDto> allOrders() {

        List <Order> allOrders =orderRepository.findAll();


        Type listType = new TypeToken<List<createOrderResponseDto>>(){}.getType();

        return modelMapper.map(allOrders,listType);
    }
}
