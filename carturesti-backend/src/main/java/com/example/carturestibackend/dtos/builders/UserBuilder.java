package com.example.carturestibackend.dtos.builders;

import com.example.carturestibackend.dtos.UserDTO;
import com.example.carturestibackend.entities.User;


public class UserBuilder {

    private UserBuilder() {
    }

    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getId_user(), user.getName(),user.getAddress(), user.getEmail(), user.getAge(), user.getRole());
    }


    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.getName(),
                userDTO.getAddress(),
                userDTO.getEmail(),
                userDTO.getAge(),
                userDTO.getRole());
    }


}
