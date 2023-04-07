package com.example.candy.dto;

import com.example.candy.entity.CandyShop;
import com.example.candy.entity.Purchase;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.candy.entity.Purchase} entity
 */
@Data
@Getter
@Setter
public class PurchaseDto implements Serializable {
    private Long id;
    private String name;
    private Double amount;
    private String dimension;
    private Long candyShopId;

    public static PurchaseDto fromEntity (Purchase purchase) {
        PurchaseDto dto = new PurchaseDto();
        dto.setId(purchase.getId());
        dto.setName(purchase.getName());
        dto.setAmount(purchase.getAmount());
        dto.setDimension(purchase.getDimension());
        dto.setCandyShopId(purchase.getCandyShop().getId());
        return dto;
    }

    public static Purchase toEntity (PurchaseDto dto) {
        Purchase purchase = new Purchase();
        purchase.setId(dto.getId());
        purchase.setName(dto.getName());
        purchase.setAmount(dto.getAmount());
        purchase.setDimension(dto.getDimension());
        return purchase;
    }
}