package com.example.candy.dto;

import com.example.candy.entity.CandyShop;
import com.example.candy.entity.FlowSheet;
import com.example.candy.entity.Ingredient;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.example.candy.entity.FlowSheet} entity
 */
@Data
@Getter
@Setter
public class FlowSheetDto implements Serializable {
    private Long id;
    private String confectioneryName;
    private List<IngredientDto> ingredients;
    private Long candyShopId;

    public static FlowSheetDto fromEntity (FlowSheet flowSheet) {
        FlowSheetDto dto = new FlowSheetDto();
        dto.setId(flowSheet.getId());
        dto.setConfectioneryName(flowSheet.getConfectioneryName());
        dto.setCandyShopId(flowSheet.getCandyShop().getId());
        List<IngredientDto> ingredients = new ArrayList<>();
        dto.setIngredients(ingredients);
        for (Ingredient ingredient : flowSheet.getIngredients()) {
            ingredients.add(IngredientDto.fromEntity(ingredient));
        }
        return dto;
    }

    public static FlowSheet toEntity (FlowSheetDto dto) {
        FlowSheet flowSheet = new FlowSheet();
        flowSheet.setId(dto.getId());
        flowSheet.setConfectioneryName(dto.getConfectioneryName());
        flowSheet.setIngredients(new ArrayList<>());
        return flowSheet;
    }
}