package com.example.carturestibackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {

    private long id_user;
    private String name;
    private String address;
    private String email;
    private int age;
    private String role;

}
