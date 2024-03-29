package com.example.carturestibackend.dtos.mappers;

import com.example.carturestibackend.dtos.PromotionDTO;
import com.example.carturestibackend.entities.Promotion;

public class PromotionMapper {

    private PromotionMapper() {
    }

    public static PromotionDTO toPromotionDTO(Promotion promotion) {
        return PromotionDTO.builder()
                .id_promotion(promotion.getId_promotion())
                .name(String.valueOf(promotion.getName()))
                .description(promotion.getDescription())
                .percentage(promotion.getPercentage())
                .products(promotion.getProducts())
                .build();
    }

    public static Promotion fromPromotionDTO(PromotionDTO promotionDTO) {
        return Promotion.builder()
                .name(promotionDTO.getName())
                .description(promotionDTO.getDescription())
                .percentage(promotionDTO.getPercentage())
                .products(promotionDTO.getProducts())
                .build();
    }
}
