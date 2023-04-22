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
        return ingredientService.findAll(-1);
    }
    @GetMapping("/{flowSheetId}")
    public List<IngredientDto> findAllByConfectioneryName(@PathVariable long flowSheetId) {
        return ingredientService.findAll(flowSheetId);
    }
    @PostMapping("/{flowSheetId}/create")
    public IngredientDto create(@PathVariable long flowSheetId, @RequestBody IngredientDto ingredientDto){
        return ingredientService.create(flowSheetId, ingredientDto);
    }
    @PutMapping("/update")
    public IngredientDto update(@RequestBody IngredientDto ingredientDto) {
        return ingredientService.update(ingredientDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        ingredientService.delete(id);
    }
}
