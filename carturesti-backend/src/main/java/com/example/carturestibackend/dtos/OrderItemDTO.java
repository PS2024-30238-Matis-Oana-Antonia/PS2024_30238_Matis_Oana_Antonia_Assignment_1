package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.Order;
import com.example.carturestibackend.entities.Product;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {

    private String id_order_item;
    private long quantity;
    private long price_per_unit;
    private Order order;
    private List<Product> products;

}
