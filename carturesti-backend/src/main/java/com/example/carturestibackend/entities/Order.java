package com.example.carturestibackend.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="orderdb")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

    public class Order {

        @Id
        @GeneratedValue(generator = "uuid")
        @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
        private String id_order;

        @Column(name = "order_date", nullable = false)
        private LocalDate order_date;

        @Column(name = "total_price", nullable = false)
        private long total_price;

        @ManyToOne
        @JoinColumn(name = "id_user")
        private User user;

        @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
        @JsonIgnore
        private List<OrderItem> orderItem;


    }

