package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.User;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {

    private Long id;
    private int rating;
    private String comment;
    private Long user;
    private Long product;
}
