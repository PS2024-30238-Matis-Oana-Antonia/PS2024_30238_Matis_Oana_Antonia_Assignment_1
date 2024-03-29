package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.entities.User;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    private OrderMapper() {
    }
    public static OrderDTO toOrderDTO(Order order) {
        return OrderDTO.builder()
                .id_order(order.getId_order())
                .order_date(order.getOrder_date())
                .total_price(order.getTotal_price())
                .id_user(order.getUser().getId_user())
                .orderItems(order.getOrderItem())
                .build();
    }

    public static Order fromOrderDTO(OrderDTO orderDTO) {
        return Order.builder()
                .order_date(orderDTO.getOrder_date())
                .total_price(orderDTO.getTotal_price())
                .user(User.builder()
                        .id_user(orderDTO.getId_user())
                        .build())
                .orderItem(orderDTO.getOrderItems())
                .build();
    }
}