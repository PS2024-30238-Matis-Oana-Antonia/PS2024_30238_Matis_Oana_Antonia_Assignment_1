package com.example.carturestibackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="productdb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id_product;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "stock", nullable = false)
    private long stock;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<Review> reviews;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

}
