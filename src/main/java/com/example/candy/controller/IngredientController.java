package com.example.candy.controller;

import com.example.candy.dto.IngredientDto;
import com.example.candy.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/ingredient")
public class IngredientController {
    private final IngredientService ingredientService;
    @GetMapping("/count")
    public long count() {
        return ingredientService.count();
    }
    @GetMapping
    public List<IngredientDto> findAll() {
        return ingredientService.findAll(null);
    }
    @GetMapping("/{name}")
    public List<IngredientDto> findAllByConfectioneryName(@PathVariable String name) {
        return ingredientService.findAll(name);
    }
    @PostMapping("/{flowSheetId}/create")
    public IngredientDto create(@PathVariable long flowSheetId, @RequestBody IngredientDto ingredientDto){
        return ingredientService.create(flowSheetId, ingredientDto);
    }
    @PutMapping("/update")
    public IngredientDto update(@RequestBody IngredientDto studentPojo) {
        return ingredientService.update(studentPojo);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        ingredientService.delete(id);
    }
}
