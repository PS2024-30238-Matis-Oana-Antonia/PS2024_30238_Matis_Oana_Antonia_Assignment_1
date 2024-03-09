package com.example.carturestibackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryDTO {

    private long id_category;
    private String name;
    private String description;
    private Set<ProductDTO> products;

}
