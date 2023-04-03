package com.example.candy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Entity(name = "Ingredient")
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "dimension", nullable = false)
    private String dimension;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flow_sheet_id", nullable = false)
    private FlowSheet flowSheet;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ingredient_name_id", nullable = false)
    private Resource ingredientName;

}