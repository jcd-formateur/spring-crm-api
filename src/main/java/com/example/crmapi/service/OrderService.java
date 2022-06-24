package com.example.crmapi.service;

import com.example.crmapi.model.Order;
import com.example.crmapi.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderRepository.deleteById(id);
    }
}
