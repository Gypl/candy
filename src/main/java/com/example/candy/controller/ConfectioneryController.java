package com.example.candy.controller;

import com.example.candy.dto.ConfectioneryDto;
import com.example.candy.service.ConfectioneryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/confectionery")
public class ConfectioneryController {
    private final ConfectioneryService confectioneryService;
    @GetMapping("/count")
    public long count() {
        return confectioneryService.count();
    }

    @GetMapping
    public List<ConfectioneryDto> findAll() {
        return confectioneryService.findAll(null);
    }

    @GetMapping("/{name}")
    public List<ConfectioneryDto> findAllByCandyShopName(@PathVariable String name) {
        return confectioneryService.findAll(name);
    }
    @PostMapping("/{confectioneryId}/create")
    public ConfectioneryDto create(@PathVariable long confectioneryId, @RequestBody ConfectioneryDto confectioneryDto){
        return confectioneryService.create(confectioneryId, confectioneryDto);
    }
    @PutMapping("/update")
    public ConfectioneryDto update(@RequestBody ConfectioneryDto studentPojo) {
        return confectioneryService.update(studentPojo);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        confectioneryService.delete(id);
    }
}
