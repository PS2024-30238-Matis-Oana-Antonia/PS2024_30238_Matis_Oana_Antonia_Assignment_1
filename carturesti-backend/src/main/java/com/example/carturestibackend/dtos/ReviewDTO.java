package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ReviewDTO {

    private Long id;
    private User user;
    private Product product;
    private int rating;
    private String comment;
    private LocalDate createdAt;
}
