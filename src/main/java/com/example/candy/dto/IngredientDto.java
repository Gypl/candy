package com.example.candy.dto;

import com.example.candy.entity.FlowSheet;
import com.example.candy.entity.Ingredient;
import com.example.candy.entity.Resource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.candy.entity.Ingredient} entity
 */
@Data
@Getter
@Setter
public class IngredientDto implements Serializable {
    private Long id;
    private Double amount;
    private String dimension;
    private Long flowSheetId;
    private String ingredientName;

    public static IngredientDto fromEntity (Ingredient ingredient) {
        IngredientDto dto = new IngredientDto();
        dto.setId(ingredient.getId());
        dto.setAmount(ingredient.getAmount());
        dto.setDimension(ingredient.getDimension());
        dto.setFlowSheetId(ingredient.getFlowSheet().getId());
        dto.setIngredientName(ingredient.getIngredientName().getResourceName());
        return dto;
    }

    public static Ingredient toEntity (IngredientDto dto) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(dto.getId());
        ingredient.setAmount(dto.getAmount());
        ingredient.setDimension(dto.getDimension());
        return ingredient;
    }
}