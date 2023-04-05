package com.example.candy.repository;

import com.example.candy.entity.CandyShop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandyShopRepository extends JpaRepository<CandyShop, Long> {
}