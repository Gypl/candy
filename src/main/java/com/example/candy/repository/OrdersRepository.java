package com.example.candy.repository;

import com.example.candy.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByCandyShop_NameIgnoreCase(String name);
}