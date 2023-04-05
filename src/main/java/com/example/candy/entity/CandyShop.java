package com.example.candy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "candy_shop")
public class CandyShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "candyShop", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<FlowSheet> flowSheets = new ArrayList<>();

    @OneToMany(mappedBy = "candyShop", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Resource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "candyShop", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Confectionery> confectioneries = new ArrayList<>();

    @OneToMany(mappedBy = "candyShop", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Purchase> purchases = new ArrayList<>();

    @OneToMany(mappedBy = "candyShop", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

}