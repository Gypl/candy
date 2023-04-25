package com.example.candy.controller;

import com.example.candy.dto.CandyShopDto;
import com.example.candy.service.CandyShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/candyShop")
public class CandyShopController {
    private final CandyShopService candyShopService;
    @GetMapping("/count")
    public long count() {
        return candyShopService.count();
    }

    @GetMapping
    public List<CandyShopDto> findAll() {
        return candyShopService.findAll(null);
    }

    @GetMapping("/{name}")
    public List<CandyShopDto> findAllByCandyShopName(@PathVariable String name) {
        return candyShopService.findAll(name);
    }
    @GetMapping("/id/{id}")
    public CandyShopDto findAllByCandyShopName(@PathVariable long id) {
        return candyShopService.findById(id);
    }
    @PostMapping("/create")
    public CandyShopDto create(@RequestBody CandyShopDto candyShopDto){
        return candyShopService.create(candyShopDto);
    }
    @PutMapping("/update")
    public CandyShopDto update(@RequestBody CandyShopDto candyShopDto) {
        return candyShopService.update(candyShopDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        candyShopService.delete(id);
    }
}
