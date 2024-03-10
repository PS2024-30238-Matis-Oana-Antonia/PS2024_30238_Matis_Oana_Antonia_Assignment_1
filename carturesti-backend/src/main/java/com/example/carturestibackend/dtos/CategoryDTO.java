package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.Product;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private long id_category;
    private String name;
    private String description;
    private Set<Product> products;

}
