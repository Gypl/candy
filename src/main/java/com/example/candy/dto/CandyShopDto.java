package com.example.candy.dto;

import com.example.candy.entity.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.example.candy.entity.CandyShop} entity
 */
@Data
@Setter
@Getter
public class CandyShopDto implements Serializable {
    private Long id;
    private String name;
    private List<FlowSheetDto> flowSheets;
    private List<ResourceDto> resources;
    private List<ConfectioneryDto> confectioneries;
    private List<PurchaseDto> purchases;
    private List<OrdersDto> orders;

    public static CandyShopDto fromEntity (CandyShop candyShop) {
        CandyShopDto dto = new CandyShopDto();
        dto.setId(candyShop.getId());
        dto.setName(candyShop.getName());

        List<FlowSheetDto> flowSheets = new ArrayList<>();
        dto.setFlowSheets(flowSheets);
        for (FlowSheet flowSheet : candyShop.getFlowSheets()) {
            flowSheets.add(FlowSheetDto.fromEntity(flowSheet));
        }

        List<ResourceDto> resources = new ArrayList<>();
        dto.setResources(resources);
        for (Resource resource : candyShop.getResources()) {
            resources.add(ResourceDto.fromEntity(resource));
        }

        List<ConfectioneryDto> confectioneries = new ArrayList<>();
        dto.setConfectioneries(confectioneries);
        for (Confectionery confectionery : candyShop.getConfectioneries()) {
            confectioneries.add(ConfectioneryDto.fromEntity(confectionery));
        }

        List<PurchaseDto> purchases = new ArrayList<>();
        dto.setPurchases(purchases);
        for (Purchase purchase : candyShop.getPurchases()) {
            purchases.add(PurchaseDto.fromEntity(purchase));
        }

        List<OrdersDto> orders = new ArrayList<>();
        dto.setOrders(orders);
        for (Orders order : candyShop.getOrders()) {
            orders.add(OrdersDto.fromEntity(order));
        }
        return dto;
    }

    public static CandyShop toEntity (CandyShopDto dto) {
        CandyShop candyShop = new CandyShop();
        candyShop.setId(dto.getId());
        candyShop.setName(dto.getName());
        candyShop.setFlowSheets(new ArrayList<>());
        candyShop.setResources(new ArrayList<>());
        candyShop.setConfectioneries(new ArrayList<>());
        candyShop.setPurchases(new ArrayList<>());
        candyShop.setOrders(new ArrayList<>());
        return candyShop;
    }
}