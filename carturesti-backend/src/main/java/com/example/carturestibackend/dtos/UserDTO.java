package com.example.carturestibackend.dtos;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private long id_user;
    private String name;
    private String address;
    private String email;
    private int age;
    private String role;
    private Set<ReviewDTO> reviews;
    private Set<OrderDTO> orders;


}
