package com.example.carturestibackend.dtos.builders;

import com.example.carturestibackend.dtos.CategoryDTO;
import com.example.carturestibackend.dtos.OrderDTO;
import com.example.carturestibackend.dtos.ProductDTO;
import com.example.carturestibackend.dtos.ReviewDTO;
import com.example.carturestibackend.entities.Product;

public class ProductBuilder {

    private ProductBuilder() {
    }

    public static ProductDTO toProductDTO(Product product) {
        return ProductDTO.builder()
                .id_product(product.getId_product())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .author(product.getAuthor())
                .stock(product.getStock())
                .build();
    }

    public static Product fromProductDTO(ProductDTO productDTO) {
        return Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .author(productDTO.getAuthor())
                .stock(productDTO.getStock())
                .build();
    }

}
