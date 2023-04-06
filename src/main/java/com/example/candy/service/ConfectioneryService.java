package com.example.candy.service;

import com.example.candy.dto.ConfectioneryDto;
import com.example.candy.entity.Confectionery;
import com.example.candy.repository.CandyShopRepository;
import com.example.candy.repository.ConfectioneryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfectioneryService {
    private final ConfectioneryRepository confectioneryRepository;
    private final CandyShopRepository candyShopRepository;

    public long count() {return confectioneryRepository.count();}

    /**
     * Возвращает все изделия для сущности кондитерская.
     * @param name Название кондитерской изделия.
     * @return Все изделия указанной кондитерской.
     */
    public List<ConfectioneryDto> findAll (String name) {
        List<ConfectioneryDto> result = new ArrayList<>();
        for (Confectionery confectionery : name == null
                ? confectioneryRepository.findAll() : confectioneryRepository.findByCandyShop_NameIgnoreCase(name)) {
            result.add(ConfectioneryDto.fromEntity(confectionery));
        }
        return result;
    }

    /**
     * Обновляет переменные изделия.
     * @param confectioneryDto Новые параметры сущности.
     * @return Возвращает запись Confectionery.
     */
    public ConfectioneryDto update (ConfectioneryDto confectioneryDto) {
        Confectionery confectionery = confectioneryRepository.findById(confectioneryDto.getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ConfectioneryDto.fromEntity(confectioneryRepository.save(confectionery));
    }

    /**
     * Создание новой записи сущности Confectionery.
     * @param candyShopId Идентификатор кондитерской.
     * @param confectioneryDto Параметры сущности.
     * @return Возвращает запись Confectionery.
     */
    public ConfectioneryDto create (long candyShopId, ConfectioneryDto confectioneryDto) {
        Confectionery confectionery = ConfectioneryDto.toEntity(confectioneryDto);
        confectionery.setCandyShop(candyShopRepository.findById(candyShopId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ConfectioneryDto.fromEntity(confectioneryRepository.save(confectionery));
    }

    /**
     * Удаление записи сущности Confectionery.
     * @param id Идентификатор изделия.
     */
    public void delete (long id) {
        if (confectioneryRepository.existsById(id)) {
            confectioneryRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
