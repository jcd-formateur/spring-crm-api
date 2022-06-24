package com.example.crmapi.dto;

import com.example.crmapi.model.Client;
import com.example.crmapi.model.Order;
import com.example.crmapi.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class OrderMapper {

    public static OrderDTO buildOrderDTO(Order order) {

        OrderDTO dto = new OrderDTO();
        dto.setClientDTO(ClientMapper.buildClientDTO(order.getClient()));
        dto.setDesignation(order.getDesignation());
        dto.setId(order.getId());
        dto.setNbDays(order.getNbDays());
        dto.setTypePresta(order.getTypePresta());
        dto.setUnitPrice(order.getUnitPrice());

        switch (order.getState()) {
            case 0:
                dto.setState("cancelled");
                break;
            case 1:
                dto.setState("option");
                break;
            case 2:
                dto.setState("confirmed");
                break;
            default:
                dto.setState("");
        }
        return dto;
    }

    public static Order buildOrder(OrderDTO orderDTO, Client client) {

        Order order = new Order();
        order.setDesignation(orderDTO.getDesignation());
        order.setId(orderDTO.getId());
        order.setNbDays(orderDTO.getNbDays());
        order.setTypePresta(orderDTO.getTypePresta());
        order.setUnitPrice(orderDTO.getUnitPrice());

        order.setClient(client);

        switch (orderDTO.getState()) {
            case "cancelled":
                order.setState(0);
                break;
            case "option":
                order.setState(1);
                break;
            case "confirmed":
                order.setState(2);
                break;
            default:
                order.setState(0);
        }
        return order;
    }
}
