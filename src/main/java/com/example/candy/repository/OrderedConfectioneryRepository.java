package com.example.candy.repository;

import com.example.candy.entity.OrderedConfectionery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderedConfectioneryRepository extends JpaRepository<OrderedConfectionery, Long> {
    List<OrderedConfectionery> findByOrders_Id(Long id);
}