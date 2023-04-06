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

    @GetMapping("/{number}")
    public List<OrderedConfectioneryDto> findAllByOrdersNumber(@PathVariable Long number) {
        return orderedConfectioneryService.findAll(number);
    }
    @PostMapping("/{orderedConfectioneryId}/create")
    public OrderedConfectioneryDto create(@PathVariable long orderedConfectioneryId, @RequestBody OrderedConfectioneryDto orderedConfectioneryDto){
        return orderedConfectioneryService.create(orderedConfectioneryId, orderedConfectioneryDto);
    }
    @PutMapping("/update")
    public OrderedConfectioneryDto update(@RequestBody OrderedConfectioneryDto studentPojo) {
        return orderedConfectioneryService.update(studentPojo);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        orderedConfectioneryService.delete(id);
    }
}
