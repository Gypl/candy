package com.example.candy.controller;

import com.example.candy.dto.ResourceDto;
import com.example.candy.repository.CandyShopRepository;
import com.example.candy.service.CandyShopService;
import com.example.candy.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/resource")
public class ResourceController {
    private final CandyShopService candyShopService;
    private final ResourceService resourceService;
    @GetMapping("/count")
    public long count() {
        return resourceService.count();
    }

    @GetMapping
    public List<ResourceDto> findAll() {
        return resourceService.findAll(null);
    }

    @GetMapping("/shop")
    public List<ResourceDto> findAllByCandyShopName(@PathVariable String shopName) {
        return resourceService.findAll(shopName);
    }
    @PostMapping("/create")
    public ResourceDto create(@PathVariable String shopName, @RequestBody ResourceDto resourceDto){
        long shopId = candyShopService.getIdByName(shopName);
        return resourceService.create(shopId, resourceDto);
    }
    @PutMapping("/update")
    public ResourceDto update(@RequestBody ResourceDto resourceDto) {
        return resourceService.update(resourceDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        resourceService.delete(id);
    }
}
