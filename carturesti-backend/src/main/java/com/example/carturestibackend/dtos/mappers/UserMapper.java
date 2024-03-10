package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.Review;
import com.example.carturestibackend.entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    private UserMapper() {
    }

    public static UserDTO toUserDTO(User user) {
        List<ReviewDTO> reviewDTOs = new ArrayList<>();
        for (Review review : user.getReviews()) {
            reviewDTOs.add(ReviewMapper.toReviewDTO(review));
        }

        List<OrderDTO> orderDTOs = new ArrayList<>();
        for (Order order : user.getOrders()) {
            orderDTOs.add(OrderMapper.toOrderDTO(order));
        }
        return UserDTO.builder()
                .id_user(user.getId_user())
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .age(user.getAge())
                .role(user.getRole())
                .reviews(reviewDTOs)
                .orders(orderDTOs)
                .build();

    }

    public static User fromUserDTO(UserDTO userDto) {
        List<Review> reviews = new ArrayList<>();
        for (ReviewDTO reviewDTO : userDto.getReviews()) {
            reviews.add(ReviewMapper.fromReviewDTO(reviewDTO));
        }

        List<Order> orders = new ArrayList<>();
        for (OrderDTO orderDTO : userDto.getOrders()) {
            orders.add(OrderMapper.fromOrderDTO(orderDTO));
        }

        return User.builder()
                .name(userDto.getName())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .age(userDto.getAge())
                .role(userDto.getRole())
                .reviews(reviews)
                .orders(orders)
                .build();
    }
}
