package com.example.candy.repository;

import com.example.candy.entity.FlowSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlowSheetRepository extends JpaRepository<FlowSheet, Long> {
    List<FlowSheet> findByCandyShop_NameIgnoreCase(String name);

    FlowSheet findFlowSheetByConfectioneryName(String name);

    FlowSheet findByConfectioneryNameIgnoreCase(String confectioneryName);


}