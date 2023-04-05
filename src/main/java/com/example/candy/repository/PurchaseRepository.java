package com.example.candy.repository;

import com.example.candy.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    List<Purchase> findByCandyShop_NameIgnoreCase(String name);
}