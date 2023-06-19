package com.app.michellerestaurant.entity;


import com.app.michellerestaurant.enums.order.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orderId;

    @Column(name = "phone")
    private  Integer phone;
    
    @Column(name = "address")
    private String address;
    @Column(name = "totalprice")
    private Integer totalPrice;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    @JsonIgnore
    @OneToMany(fetch=FetchType.EAGER)
    private List<OrderItem> orderItems;
}
