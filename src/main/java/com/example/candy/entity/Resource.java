package com.example.candy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Column(name = "resource_name", nullable = false, unique = true)
    private String resourceName;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "dimension", nullable = false)
    private String dimension;

    @ManyToOne
    @JoinColumn(name = "candy_shop_id")
    private CandyShop candyShop;

}