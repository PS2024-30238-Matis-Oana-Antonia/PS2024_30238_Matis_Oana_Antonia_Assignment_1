package com.example.carturestibackend.dtos;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private long id_order;
    private long nbOfProducts;
    private long total_price;
    private UserDTO user;
    private List<ProductDTO> products;
}
