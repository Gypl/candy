package com.example.candy.service;

import com.example.candy.dto.IngredientDto;
import com.example.candy.entity.Ingredient;
import com.example.candy.repository.FlowSheetRepository;
import com.example.candy.repository.IngredientRepository;
import com.example.candy.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository ingredientRepository;
    private final FlowSheetRepository flowSheetRepository;
    private final ResourceRepository resourceRepository;

    public long count() {return ingredientRepository.count();}

    /**
     * Возвращает все ингредиенты для сущности карты приготовления по названию изделия.
     * @param id Идентификатор тех. карты изделия.
     * @return Ингредиенты сущности flowSheet по названию имени изделия.
     */
    public List<IngredientDto> findAll (long id) {
        List<IngredientDto> result = new ArrayList<>();
        for (Ingredient ingredient : id == -1
                ? ingredientRepository.findAll() : ingredientRepository.findAllById(id)) {
            result.add(IngredientDto.fromEntity(ingredient));
        }
        return result;
    }

    /**
     * Обновляет перемнные Ingredient.
     * @param ingredientDto Новые параметры сущности.
     * @return Количество обновлённых записей.
     */
    public IngredientDto update (IngredientDto ingredientDto) {
        Ingredient ingredient = ingredientRepository.findById(ingredientDto.getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FlowSheer doesn't exist."));
        ingredient = IngredientDto.toEntity(ingredientDto);
        ingredient.setFlowSheet(flowSheetRepository.findByConfectioneryNameIgnoreCase(ingredientDto.getIngredientName()));
        ingredient.setIngredientName(resourceRepository.findByCandyShop_IdAndResourceNameIgnoreCase(
                flowSheetRepository.getReferenceById(ingredientDto.getFlowSheetId()).getCandyShop().getId(),
                ingredientDto.getIngredientName()
        ));
        return IngredientDto.fromEntity(ingredientRepository.save(ingredient));
    }

    /**
     * Создание новой записи сущности Ingredient.
     * @param flowSheetId Идентификатор тех карты.
     * @param ingredientDto Параметры сущности.
     * @return
     */
    public IngredientDto create (long flowSheetId, IngredientDto ingredientDto) {
        Ingredient ingredient = IngredientDto.toEntity(ingredientDto);
        ingredient.setFlowSheet(flowSheetRepository.findById(flowSheetId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "FlowSheer doesn't exist.")));
        ingredient.setIngredientName(resourceRepository.findByCandyShop_IdAndResourceNameIgnoreCase(
                flowSheetRepository.getReferenceById(flowSheetId).getCandyShop().getId(),
                ingredientDto.getIngredientName()));
        return IngredientDto.fromEntity(ingredientRepository.save(ingredient));
    }

    /**
     * Удаление записи сущности Ingredient.
     * @param id Идентификатор ингредиентаю
     */
    public void delete (long id) {
        if (ingredientRepository.existsById(id)) {
            ingredientRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
