package com.example.carturestibackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="orderitemdb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OrderItem {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id_order_item;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "price_per_unit", nullable = false)
    private long price_per_unit;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToMany
    @JoinTable(
            name = "order_item_product",
            joinColumns = @JoinColumn(name = "id_order_item"),
            inverseJoinColumns = @JoinColumn(name = "id_product"))
    @JsonIgnore
    private List<Product> products;
}

