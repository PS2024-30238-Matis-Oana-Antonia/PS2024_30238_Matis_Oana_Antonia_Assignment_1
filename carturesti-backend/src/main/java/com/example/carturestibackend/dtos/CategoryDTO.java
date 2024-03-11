package com.example.carturestibackend.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDTO {

    private long id_category;
    private String name;
    private String description;
    private List<Long> products;

}
