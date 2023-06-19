package com.app.michellerestaurant.repository;

import com.app.michellerestaurant.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository <Order, UUID> {

}
