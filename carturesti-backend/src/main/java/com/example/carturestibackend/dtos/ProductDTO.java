package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.Review;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private long id_product;
    private String name;
    private long price;
    private List<Long> categories;
    private List<Long> orders;
    private List<Long> reviews;
    private String description;
    private String author;
    private long stock;

}
