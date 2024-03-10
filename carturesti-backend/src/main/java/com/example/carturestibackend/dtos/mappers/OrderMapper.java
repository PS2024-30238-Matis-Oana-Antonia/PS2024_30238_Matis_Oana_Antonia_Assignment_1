package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.entities.Order;

public class OrderMapper {
    private OrderMapper() {
    }
    public static OrderDTO toOrderDTO(Order order) {
        return OrderDTO.builder()
                .id_order(order.getId_order())
                .nbOfProducts(order.getNbOfProducts())
                .total_price(order.getTotal_price())
                .build();
    }

    public static Order fromOrderDTO(OrderDTO orderDTO) {
        return Order.builder()
                .nbOfProducts(orderDTO.getNbOfProducts())
                .total_price(orderDTO.getTotal_price())
                .build();
    }

}
