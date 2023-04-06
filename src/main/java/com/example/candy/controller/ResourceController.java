package com.example.candy.controller;

import com.example.candy.dto.ResourceDto;
import com.example.candy.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/resource")
public class ResourceController {
    private final ResourceService resourceService;
    @GetMapping("/count")
    public long count() {
        return resourceService.count();
    }

    @GetMapping
    public List<ResourceDto> findAll() {
        return resourceService.findAll(null);
    }

    @GetMapping("/{name}")
    public List<ResourceDto> findAllByCandyShopName(@PathVariable String name) {
        return resourceService.findAll(name);
    }
    @PostMapping("/{resourceId}/create")
    public ResourceDto create(@PathVariable long resourceId, @RequestBody ResourceDto resourceDto){
        return resourceService.create(resourceId, resourceDto);
    }
    @PutMapping("/update")
    public ResourceDto update(@RequestBody ResourceDto studentPojo) {
        return resourceService.update(studentPojo);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        resourceService.delete(id);
    }
}
