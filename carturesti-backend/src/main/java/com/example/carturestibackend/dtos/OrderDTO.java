package com.example.carturestibackend.dtos;
import com.example.carturestibackend.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDTO {

    private long id_order;
    private long nbOfProducts;
    private long total_price;
    private UserDTO user;
    private Set<ProductDTO> products;
}
