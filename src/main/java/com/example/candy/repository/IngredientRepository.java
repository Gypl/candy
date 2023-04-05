package com.example.candy.repository;

import com.example.candy.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByFlowSheet_ConfectioneryNameIgnoreCase(String confectioneryName);
}