package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.Review;
import lombok.*;

import java.util.List;
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
    private List<ReviewDTO> reviews;
    private List<OrderDTO> orders;

}
