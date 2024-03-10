package com.example.carturestibackend.dtos;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {

    private Long id;
    private UserDTO user;
    private ProductDTO product;
    private int rating;
    private String comment;
    private LocalDate createdAt;
}
