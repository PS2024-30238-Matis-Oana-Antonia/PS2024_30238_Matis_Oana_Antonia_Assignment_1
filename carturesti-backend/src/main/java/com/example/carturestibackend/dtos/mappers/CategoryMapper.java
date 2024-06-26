package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.CategoryDTO;
import com.example.carturestibackend.entities.Category;
import com.example.carturestibackend.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {

    public static CategoryDTO toCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id_category(category.getId_category())
                .name(category.getName())
                .description(category.getDescription())
                .products(category.getProducts())
                .build();
    }

    public static Category fromCategoryDTO(CategoryDTO categoryDTO) {
        return Category.builder()
                .id_category(categoryDTO.getId_category())
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .products(categoryDTO.getProducts())
                .build();
    }
}
