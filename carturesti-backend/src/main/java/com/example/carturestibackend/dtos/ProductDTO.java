package com.example.carturestibackend.dtos;


import java.util.List;
import java.util.Set;

import com.example.carturestibackend.entities.Category;
import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.Review;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private long id_product;
    private String name;
    private long price;
    private List<CategoryDTO> categories;
    private List<OrderDTO> orders;
    private List<ReviewDTO> reviews;
    private String description;
    private String author;
    private long stock;

}
