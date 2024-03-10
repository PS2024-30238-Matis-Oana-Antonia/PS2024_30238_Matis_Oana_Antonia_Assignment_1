package com.example.carturestibackend.dtos.builders;

import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.dtos.CategoryDTO;

import java.util.Set;

public class ProductBuilder {
    public static ProductDTO toProductDTO(Product product) {
        return ProductDTO.builder()
                .id_product(product.getId_product())
                .name(product.getName())
                .price(product.getPrice())
                .categories(product.getCategories())
                .orders(product.getOrders())
                .reviews(product.getReviews())
                .description(product.getDescription())
                .author(product.getAuthor())
                .stock(product.getStock())
                .build();
    }

    public static Product fromProductDTO(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .categories(productDTO.getCategories())
                .orders(productDTO.getOrders())
                .reviews(productDTO.getReviews())
                .description(productDTO.getDescription())
                .author(productDTO.getAuthor())
                .stock(productDTO.getStock())
                .build();
    }


}
