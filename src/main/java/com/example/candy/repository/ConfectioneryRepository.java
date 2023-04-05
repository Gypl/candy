package com.example.candy.repository;

import com.example.candy.entity.Confectionery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfectioneryRepository extends JpaRepository<Confectionery, Long> {
    List<Confectionery> findByCandyShop_NameIgnoreCase(String name);
}