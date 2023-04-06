package com.example.candy.controller;

import com.example.candy.dto.FlowSheetDto;
import com.example.candy.service.FlowSheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/flowSheet")
public class FlowSheetController {
    private final FlowSheetService flowSheetService;
    @GetMapping("/count")
    public long count() {
        return flowSheetService.count();
    }

    @GetMapping
    public List<FlowSheetDto> findAll() {
        return flowSheetService.findAll(null);
    }

    @GetMapping("/{name}")
    public List<FlowSheetDto> findAllByCandyShopName(@PathVariable String name) {
        return flowSheetService.findAll(name);
    }
    @PostMapping("/{flowSheetId}/create")
    public FlowSheetDto create(@PathVariable long flowSheetId, @RequestBody FlowSheetDto flowSheetDto){
        return flowSheetService.create(flowSheetId, flowSheetDto);
    }
    @PutMapping("/update")
    public FlowSheetDto update(@RequestBody FlowSheetDto studentPojo) {
        return flowSheetService.update(studentPojo);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        flowSheetService.delete(id);
    }
}
