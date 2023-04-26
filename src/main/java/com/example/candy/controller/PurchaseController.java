package com.example.candy.controller;

import com.example.candy.dto.PurchaseDto;
import com.example.candy.service.CandyShopService;
import com.example.candy.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/purchase")
public class PurchaseController {
    private final CandyShopService candyShopService;
    private final PurchaseService purchaseService;
    @GetMapping("/count")
    public long count() {
        return purchaseService.count();
    }

    @GetMapping
    public List<PurchaseDto> findAll() {
        return purchaseService.findAll(null);
    }

    @GetMapping("/shop")
    public List<PurchaseDto> findAllByCandyShopName(@PathVariable String shopName) {
        return purchaseService.findAll(shopName);
    }
    @PostMapping("/create")
    public PurchaseDto create(@PathVariable String shopName, @RequestBody PurchaseDto purchaseDto){
        long shopId = candyShopService.getIdByName(shopName);
        return purchaseService.create(shopId, purchaseDto);
    }
    @PutMapping("/update")
    public PurchaseDto update(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.update(purchaseDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        purchaseService.delete(id);
    }
}
