package com.example.crmapi.controller;

import com.example.crmapi.dto.OrderDTO;
import com.example.crmapi.dto.OrderMapper;
import com.example.crmapi.model.Client;
import com.example.crmapi.model.Order;
import com.example.crmapi.service.ClientService;
import com.example.crmapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    ClientService clientService;

    @GetMapping("orders")
    public List<OrderDTO> getAll() {

        // conversion des Entity en DTO:
        List<OrderDTO> dtos = new ArrayList<>();
        List<Order> entities = orderService.getOrders();
        for (Order order: entities         ) {
            dtos.add(OrderMapper.buildOrderDTO(order));
        }

        return dtos;
    }

    @GetMapping("orders/{id}")
    public OrderDTO getById(@PathVariable Long id) {

        Order order = orderService.getOrderById(id);

        // conversion Entity en DTO:
        OrderDTO dto = OrderMapper.buildOrderDTO(order);

        return dto;
    }

    @PostMapping("orders")
    public void createOrder(@RequestBody OrderDTO orderDTO) {

        // conversion du DTO en Entity:
        Client client = clientService.getClientById(orderDTO.getClientDTO().getId());
        Order order = OrderMapper.buildOrder(orderDTO, client);

        orderService.createOrder(order);
    }

    @PutMapping("orders/{id}")
    public void updateOrder(@RequestBody OrderDTO orderDTO) {

        // conversion du DTOs en Entity:
        Client client = clientService.getClientById(orderDTO.getClientDTO().getId());
        Order order = OrderMapper.buildOrder(orderDTO, client);

        orderService.updateOrder(order);
    }

    @DeleteMapping("orders/{id}")
    public void deleteOrder(@PathVariable Long id) {

        orderService.deleteOrder(id);
    }
}
