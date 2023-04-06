package com.example.candy.service;

import com.example.candy.dto.FlowSheetDto;
import com.example.candy.entity.FlowSheet;
import com.example.candy.repository.CandyShopRepository;
import com.example.candy.repository.FlowSheetRepository;
import com.example.candy.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlowSheetService {
    private final FlowSheetRepository flowSheetRepository;
    private final CandyShopRepository candyShopRepository;

    public long count() {return flowSheetRepository.count();}

    /**
     * Возвращает все тех. карты для сущности кондитерская.
     * @param name Название кондитерской тех. карты.
     * @return Все тех. карты указанной кондитерской.
     */
    public List<FlowSheetDto> findAll (String name) {
        List<FlowSheetDto> result = new ArrayList<>();
        for (FlowSheet flowSheet : name == null
                ? flowSheetRepository.findAll() : flowSheetRepository.findByCandyShop_NameIgnoreCase(name)) {
            result.add(FlowSheetDto.fromEntity(flowSheet));
        }
        return result;
    }

    /**
     * Обновляет перемнные тех. карты.
     * @param flowSheetDto Новые параметры сущности.
     * @return Возвращает запись FlowSheet.
     */
    public FlowSheetDto update (FlowSheetDto flowSheetDto) {
        FlowSheet flowSheet = flowSheetRepository.findById(flowSheetDto.getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        flowSheet = FlowSheetDto.toEntity(flowSheetDto);
        return FlowSheetDto.fromEntity(flowSheetRepository.save(flowSheet));
    }

    /**
     * Создание новой записи сущности FlowSheet.
     * @param candyShopId Идентификатор кондитерской.
     * @param flowSheetDto Параметры сущности.
     * @return Возвращает запись FlowSheet.
     */
    public FlowSheetDto create (long candyShopId, FlowSheetDto flowSheetDto) {
        FlowSheet flowSheet = FlowSheetDto.toEntity(flowSheetDto);
        flowSheet.setCandyShop(candyShopRepository.findById(candyShopId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return FlowSheetDto.fromEntity(flowSheetRepository.save(flowSheet));
    }

    /**
     * Удаление записи сущности FlowSheet.
     * @param id Идентификатор тех. карты.
     */
    public void delete (long id) {
        if (flowSheetRepository.existsById(id)) {
            flowSheetRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
