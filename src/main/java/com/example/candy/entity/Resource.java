package com.example.candy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity(name = "Resource")
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "resource_name", nullable = false)
    private String resourceName;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "dimension", nullable = false)
    private String dimension;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "candy_shop_id", nullable = false)
    private CandyShop candyShop;

}