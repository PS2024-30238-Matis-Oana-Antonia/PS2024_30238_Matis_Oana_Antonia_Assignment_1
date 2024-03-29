package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.dtos.OrderItemDTO;
import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.OrderItem;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.entities.User;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {
    private OrderItemMapper() {
    }
    public static OrderItemDTO toOrderItemDTO(OrderItem orderItem) {
        return OrderItemDTO.builder()
                .id_order_item(orderItem.getId_order_item())
                .quantity(orderItem.getQuantity())
                .price_per_unit(orderItem.getPrice_per_unit())
                .order(orderItem.getOrder())
                .build();
    }

    public static OrderItem fromOrderItemDTO(OrderItemDTO orderItemDTO) {
        return OrderItem.builder()
                .quantity(orderItemDTO.getQuantity())
                .price_per_unit(orderItemDTO.getPrice_per_unit())
                .order(orderItemDTO.getOrder())
                .build();
    }
}
