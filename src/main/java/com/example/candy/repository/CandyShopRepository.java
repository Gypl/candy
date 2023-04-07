package com.example.candy.repository;

import com.example.candy.entity.CandyShop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CandyShopRepository extends JpaRepository<CandyShop, Long> {
    List<CandyShop> findByNameIgnoreCase(String name);

    CandyShop findCandyShopByNameIgnoreCase(String name);

    boolean existsByName(String name);


}