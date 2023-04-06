package com.example.candy.service;

import com.example.candy.dto.PurchaseDto;
import com.example.candy.dto.ResourceDto;
import com.example.candy.entity.Purchase;
import com.example.candy.entity.Resource;
import com.example.candy.repository.CandyShopRepository;
import com.example.candy.repository.PurchaseRepository;
import com.example.candy.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final CandyShopRepository candyShopRepository;

    public long count() {return purchaseRepository.count();}

    /**
     * Возвращает все покупки для сущности кондитерская.
     * @param name Название кондитерской которой принадлежат покупки.
     * @return Все покупки указанной кондитерской.
     */

    public List<PurchaseDto> findAll (String name) {
        List<PurchaseDto> result = new ArrayList<>();
        for (Purchase purchase : name == null
                ? purchaseRepository.findAll() : purchaseRepository.findByCandyShop_NameIgnoreCase(name)) {
            result.add(PurchaseDto.fromEntity(purchase));
        }
        return result;
    }

    /**
     * Обновляет перемнные покупок.
     * @param purchaseDto Новые параметры сущности.
     * @return Возвращает запись Purchase.
     */
    public PurchaseDto update (PurchaseDto purchaseDto) {
        Purchase purchase = purchaseRepository.findById(purchaseDto.getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return PurchaseDto.fromEntity(purchaseRepository.save(purchase));
    }

    /**
     * Создание новой записи сущности Purchase.
     * @param candyShopId Идентификатор кондитерской.
     * @param purchaseDto Параметры сущности.
     * @return Возвращает запись Purchase.
     */
    public PurchaseDto create (long candyShopId, PurchaseDto purchaseDto) {
        Purchase purchase = PurchaseDto.toEntity(purchaseDto);
        purchase.setCandyShop(candyShopRepository.findById(candyShopId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return PurchaseDto.fromEntity(purchaseRepository.save(purchase));
    }

    /**
     * Удаление записи сущности Purchase.
     * @param id Идентификатор покупки.
     */
    public void delete (long id) {
        if (purchaseRepository.existsById(id)) {
            purchaseRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
