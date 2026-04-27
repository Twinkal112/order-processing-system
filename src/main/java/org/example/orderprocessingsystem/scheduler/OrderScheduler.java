package org.example.orderprocessingsystem.scheduler;


import lombok.RequiredArgsConstructor;
import org.example.orderprocessingsystem.entity.Order;
import org.example.orderprocessingsystem.entity.OrderStatus;
import org.example.orderprocessingsystem.repository.OrderRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderScheduler {

    private final OrderRepository repository;

    @Scheduled(fixedRate = 300000) // 5 minutes
    public void updatePendingOrders() {


        List<Order> orders = repository.findByStatus(OrderStatus.PENDING);

        orders.forEach(order -> order.setStatus(OrderStatus.PROCESSING));

        repository.saveAll(orders);
    }


}
