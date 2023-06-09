package com.example.candy.controller;

import com.example.candy.dto.OrderedConfectioneryDto;
import com.example.candy.service.OrderedConfectioneryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/orderedConfectionery")
public class OrderedConfectioneryController {
    private final OrderedConfectioneryService orderedConfectioneryService;
    @GetMapping("/count")
    public long count() {
        return orderedConfectioneryService.count();
    }

    @GetMapping
    public List<OrderedConfectioneryDto> findAll() {
        return orderedConfectioneryService.findAll(null);
    }

    @GetMapping("/{ordersId}")
    public List<OrderedConfectioneryDto> findAllByOrdersNumber(@PathVariable Long ordersId) {
        return orderedConfectioneryService.findAll(ordersId);
    }
    @PostMapping("/{ordersId}/create")
    public OrderedConfectioneryDto create(@PathVariable long ordersId, @RequestBody OrderedConfectioneryDto orderedConfectioneryDto){
        return orderedConfectioneryService.create(ordersId, orderedConfectioneryDto);
    }
    @PutMapping("/update")
    public OrderedConfectioneryDto update(@RequestBody OrderedConfectioneryDto orderedConfectioneryDto) {
        return orderedConfectioneryService.update(orderedConfectioneryDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        orderedConfectioneryService.delete(id);
    }
}
