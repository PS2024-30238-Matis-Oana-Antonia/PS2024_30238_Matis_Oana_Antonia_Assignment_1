package com.example.carturestibackend.dtos.builders;

import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.entities.User;

import java.util.Collections;
import java.util.Set;

public class OrderBuilder {
    private OrderBuilder() {
    }
    public static OrderDTO toOrderDTO(Order order) {
        return OrderDTO.builder()
                .id_order(order.getId_order())
                .nbOfProducts(order.getNbOfProducts())
                .total_price(order.getTotal_price())
                .user(UserBuilder.toUserDTO(order.getUser()))
                .products(Collections.singleton(ProductBuilder.toProductDTO((Product) order.getProducts())))
                .build();
    }

    public static Order fromOrderDTO(OrderDTO orderDTO) {
        return Order.builder()
                .nbOfProducts(orderDTO.getNbOfProducts())
                .total_price(orderDTO.getTotal_price())
                .user(UserBuilder.fromUserDTO(orderDTO.getUser()))
                .products(Collections.singleton(ProductBuilder.fromProductDTO((ProductDTO) orderDTO.getProducts())))
                .build();
    }

}
