package com.example.carturestibackend.dtos;

import com.example.carturestibackend.entities.OrderItem;
import com.example.carturestibackend.entities.Product;
import com.example.carturestibackend.entities.User;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDTO {

    private String id_order;
    private LocalDate order_date;
    private long total_price;
    private String id_user;
    private List<OrderItem> orderItems;
}
