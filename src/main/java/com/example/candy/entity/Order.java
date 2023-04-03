package com.example.candy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "Order")
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "order_number", nullable = false)
    private Long orderNumber;

    @OneToMany(mappedBy = "order", orphanRemoval = true)
    private List<OrderedConfectionery> orderedConfectioneries = new ArrayList<>();

    @Column(name = "start_ready")
    private Boolean startReady;

    @Column(name = "serve_ready")
    private Boolean serveReady;

    @ManyToOne
    @JoinColumn(name = "candy_shop_id")
    private CandyShop candyShop;

}