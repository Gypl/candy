package com.example.candy.controller;

import com.example.candy.dto.OrdersDto;
import com.example.candy.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/orders")
public class OrdersController {
    private final OrdersService ordersService;
    @GetMapping("/count")
    public long count() {
        return ordersService.count();
    }

    @GetMapping
    public List<OrdersDto> findAll() {
        return ordersService.findAll(null);
    }

    @GetMapping("/{name}")
    public List<OrdersDto> findAllByCandyShopName(@PathVariable String name) {
        return ordersService.findAll(name);
    }
    @PostMapping("/{ordersId}/create")
    public OrdersDto create(@PathVariable long ordersId, @RequestBody OrdersDto ordersDto){
        return ordersService.create(ordersId, ordersDto);
    }
    @PutMapping("/update")
    public OrdersDto update(@RequestBody OrdersDto studentPojo) {
        return ordersService.update(studentPojo);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        ordersService.delete(id);
    }
}
