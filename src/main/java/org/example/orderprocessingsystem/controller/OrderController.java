package org.example.orderprocessingsystem.controller;


import lombok.RequiredArgsConstructor;
import org.example.orderprocessingsystem.entity.Order;
import org.example.orderprocessingsystem.entity.OrderStatus;
import org.example.orderprocessingsystem.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {



    private final OrderService service;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return service.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order get(@PathVariable Long id) {
        return service.getOrder(id);
    }

    @GetMapping
    public List<Order> list(@RequestParam(required = false) OrderStatus status) {
        return service.getOrders(status);
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id, @RequestParam OrderStatus status) {
        return service.updateStatus(id, status);
    }

    @PutMapping("/{id}/cancel")
    public Order cancel(@PathVariable Long id) {
        return service.cancelOrder(id);
    }
}
