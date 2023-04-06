package com.example.candy.service;

import com.example.candy.dto.CandyShopDto;
import com.example.candy.entity.CandyShop;
import com.example.candy.repository.CandyShopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CandyShopService {
    private final CandyShopRepository candyShopRepository;

    public long count() {return candyShopRepository.count();}

    /**
     * Возвращает все кондитерские.
     * @param name Идентификатор кондитерской.
     * @return Все кондитерскую.
     */
    public List<CandyShopDto> findAll (String name) {
        List<CandyShopDto> result = new ArrayList<>();
        for (CandyShop candyShop : name == null
                ? candyShopRepository.findAll() : candyShopRepository.findByNameIgnoreCase(name)) {
            result.add(CandyShopDto.fromEntity(candyShop));
        }
        return result;
    }

    /**
     * Обновляет переменные кондитерской.
     * @param candyShopDto Новые параметры сущности.
     * @return Возвращает запись CandyShop.
     */
    public CandyShopDto update (CandyShopDto candyShopDto) {
        CandyShop candyShop = candyShopRepository.findById(candyShopDto.getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        candyShop = CandyShopDto.toEntity(candyShopDto);
        return CandyShopDto.fromEntity(candyShopRepository.save(candyShop));
    }

    /**
     * Создание новой записи сущности CandyShop.
     * @param candyShopDto Параметры сущности.
     * @return Возвращает запись CandyShop.
     */
    public CandyShopDto create (CandyShopDto candyShopDto) {
        CandyShop candyShop = CandyShopDto.toEntity(candyShopDto);
        return CandyShopDto.fromEntity(candyShopRepository.save(candyShop));
    }

    /**
     * Удаление записи сущности CandyShop.
     * @param id Идентификатор кондитерской.
     */
    public void delete (long id) {
        if (candyShopRepository.existsById(id)) {
            candyShopRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
