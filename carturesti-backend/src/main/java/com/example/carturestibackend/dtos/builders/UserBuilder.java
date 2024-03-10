package com.example.carturestibackend.dtos.builders;

import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.entities.User;

import java.util.Set;


public class UserBuilder {

        private UserBuilder() {
        }

        public static UserDTO toUserDTO(User user) {
            return UserDTO.builder()
                    .id_user(user.getId_user())
                    .name(user.getName())
                    .address(user.getAddress())
                    .email(user.getEmail())
                    .age(user.getAge())
                    .role(user.getRole())
                    .build();
        }

        public static User fromUserDTO(UserDTO userDto) {
            return User.builder()
                    .name(userDto.getName())
                    .address(userDto.getAddress())
                    .email(userDto.getEmail())
                    .age(userDto.getAge())
                    .role(userDto.getRole())
                    .build();
        }

        public static UserDTO withReviews(UserDTO userDTO, Set<ReviewDTO> reviews) {
            userDTO.setReviews(reviews);
            return userDTO;
        }

        public static UserDTO withOrders(UserDTO userDTO, Set<OrderDTO> orders) {
            userDTO.setOrders(orders);
            return userDTO;
        }
    }

