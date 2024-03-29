package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.entities.User;

public class UserMapper {

    private UserMapper() {
    }

    public static UserDTO toUserDTO(User user) {

        return UserDTO.builder()
                .id_user(user.getId_user())
                .name(user.getName())
                .address(user.getAddress())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(user.getAge())
                .role(user.getRole())
                .reviews(user.getReviews())
                .orders(user.getOrders())
                .build();
    }

    public static User fromUserDTO(UserDTO userDto) {

        return User.builder()
                .name(userDto.getName())
                .address(userDto.getAddress())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .age(userDto.getAge())
                .role(userDto.getRole())
                .reviews(userDto.getReviews())
                .orders(userDto.getOrders())
                .build();
    }
}
