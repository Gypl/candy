package com.example.candy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/Ingredients")
public class IngredientController {
//    private final IngredientService ingredientService;
//    @GetMapping("/count")
//    public long count() {
//        return IngredientService.count();
//    }
//
//    @GetMapping
//    public List<IngredientDto> findAll() {
//        return ingredientService.findAll(null);
//    }
//
//    @GetMapping("/{name}")
//    public List<IngredientDto> findAllByName(@PathVariable String name) {
//        return ingredientService.findAll(name);
//    }
//    @GetMapping("/id/{id}")
//    public IngredientDto findAllByName(@PathVariable long id){
//        return ingredientService.findById(id);
//    }
//
//    @PostMapping("/create")
//    public IngredientDto create(@RequestBody IngredientDto IngredientDto){
//        return ingredientService.create(IngredientDto);
//    }
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable long id){
//        ingredientService.delete(id);
//    }
//    @GetMapping("/{IngredientId}/students")
//    public List<StudentDto> findStudents(@PathVariable long IngredientId){
//        return  ingredientService.findAllStudents(IngredientId);
//    }
//    @PostMapping("/{IngredientId}/students")
//    public StudentDto createStudent(@PathVariable long IngredientId, @RequestBody StudentDto Dto) {
//        return ingredientService.createStudent(IngredientId, Dto);
//    }
//    @PostMapping("/{IngredientId}/students/{studentId}/move")
//    public IngredientDto moveStudent(@PathVariable long IngredientId, @PathVariable long studentId){
//        return ingredientService.moveStudent(IngredientId,studentId);
//    }
}
