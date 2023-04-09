package com.example.candy.repository;

import com.example.candy.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByCandyShop_NameIgnoreCase(String name);

    Resource findByIdAndResourceNameIgnoreCase(Long id, String resourceName);

    Resource findByResourceNameIgnoreCase(String resourceName);



}