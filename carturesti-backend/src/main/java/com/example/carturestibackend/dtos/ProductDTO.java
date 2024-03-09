package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.Category;
import jakarta.persistence.*;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {

    private long id_product;
    private String name;
    private long price;
    private Set<Category> category;
    private String description;
    private String author;
    private long stock;
}
