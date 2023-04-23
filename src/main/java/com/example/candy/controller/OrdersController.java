package com.example.candy.controller;

import com.example.candy.dto.OrdersDto;
import com.example.candy.service.CandyShopService;
import com.example.candy.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/orders")
public class OrdersController {
    private final CandyShopService candyShopService;
    private final OrdersService ordersService;
    @GetMapping("/count")
    public long count() {
        return ordersService.count();
    }

    @GetMapping
    public List<OrdersDto> findAll() {
        return ordersService.findAll(null);
    }

    @GetMapping("/shop")
    public List<OrdersDto> findAllByCandyShopName(@PathVariable String shopName) {
        return ordersService.findAll(shopName);
    }
    @PostMapping("/create")
    public OrdersDto create(@PathVariable String shopName, @RequestBody OrdersDto ordersDto){
        long shopId = candyShopService.getIdByName(shopName);
        return ordersService.create(shopId, ordersDto);
    }
    @PutMapping("/update")
    public OrdersDto update(@RequestBody OrdersDto ordersDto) {
        return ordersService.update(ordersDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        ordersService.delete(id);
    }
}
