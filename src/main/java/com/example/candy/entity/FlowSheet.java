package com.example.candy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "FlowSheet")
@Table(name = "flow_sheet")
public class FlowSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "confectionery_name", unique = true)
    private String confectioneryName;

    @OneToMany(mappedBy = "flowSheet", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Ingredient> ingredients = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "candy_shop_id", nullable = false)
    private CandyShop candyShop;

}