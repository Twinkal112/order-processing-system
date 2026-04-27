package org.example.orderprocessingsystem.repository;


import org.example.orderprocessingsystem.entity.Order;
import org.example.orderprocessingsystem.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByStatus(OrderStatus status);
}