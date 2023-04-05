package com.example.candy.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Confectionery")
@Table(name = "confectionery")
public class Confectionery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "confectionery_name_id", nullable = false)
    private FlowSheet confectioneryName;

    @Column(name = "number", nullable = false)
    private Integer number;

    @ManyToOne
    @JoinColumn(name = "candy_shop_id", nullable = false)
    private CandyShop candyShop;

}