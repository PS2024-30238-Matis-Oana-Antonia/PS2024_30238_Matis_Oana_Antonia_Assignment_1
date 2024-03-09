package com.example.carturestibackend.mappers;

import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.entities.User;

public class UserMapper {

    public static User fromDto(UserDTO u) {
        return User.builder()
                .id_user(u.getId_user())
                .name(u.getName())
                .address(u.getAddress())
                .email(u.getEmail())
                .age(u.getAge())
                .role(u.getRole())
                .build();
    }
}
