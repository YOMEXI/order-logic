package com.app.michellerestaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "order_items")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
   // @OneToMany(fetch=FetchType.EAGER,orphanRemoval = true)
   // private Product products  ;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "products",nullable = false)
    private Product products  ;

   // @ManyToOne(fetch = FetchType.EAGER)
  //  @JoinColumn(name = "order_items", nullable = false)
   // private Order order_items;
}
