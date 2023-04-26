package com.example.candy.controller;

import com.example.candy.dto.FlowSheetDto;
import com.example.candy.service.CandyShopService;
import com.example.candy.service.FlowSheetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/{shopName}/flowSheet")
public class FlowSheetController {
    private final CandyShopService candyShopService;
    private final FlowSheetService flowSheetService;
    @GetMapping("/count")
    public long count() {
        return flowSheetService.count();
    }

    @GetMapping
    public List<FlowSheetDto> findAll() {
        return flowSheetService.findAll(null);
    }

    @GetMapping("/shop")
    public List<FlowSheetDto> findAllByCandyShopName(@PathVariable String shopName) {
        return flowSheetService.findAll(shopName);
    }
    @PostMapping("/create")
    public FlowSheetDto create(@PathVariable String shopName, @RequestBody FlowSheetDto flowSheetDto){
        long shopId = candyShopService.getIdByName(shopName);
        return flowSheetService.create(shopId, flowSheetDto);
    }
    @PutMapping("/update")
    public FlowSheetDto update(@RequestBody FlowSheetDto flowSheetDto) {
        return flowSheetService.update(flowSheetDto);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        flowSheetService.delete(id);
    }
}
