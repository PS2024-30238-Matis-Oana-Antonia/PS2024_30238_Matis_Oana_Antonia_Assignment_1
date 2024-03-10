package com.example.carturestibackend.dtos.builders;

import com.example.carturestibackend.dtos.CategoryDTO;
import com.example.carturestibackend.entities.Category;

import java.util.stream.Collectors;

public class CategoryBuilder {

    public static CategoryDTO toCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id_category(category.getId_category())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public static Category fromCategoryDTO(CategoryDTO categoryDTO) {
        return Category.builder()
                .id_category(categoryDTO.getId_category())
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .build();
    }
}
