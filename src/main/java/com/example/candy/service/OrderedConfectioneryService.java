package com.example.candy.service;

import com.example.candy.dto.OrderedConfectioneryDto;
import com.example.candy.entity.OrderedConfectionery;
import com.example.candy.repository.FlowSheetRepository;
import com.example.candy.repository.OrderedConfectioneryRepository;
import com.example.candy.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderedConfectioneryService {
    private final OrderedConfectioneryRepository orderedConfectioneryRepository;
    private final OrdersRepository ordersRepository;
    private final FlowSheetRepository flowSheetRepository;

    public long count() {return orderedConfectioneryRepository.count();}

    /**
     * Возвращает все позиции заказа для сущности Orders.
     * @param id Идентификатор заказа которому принадлежат позиции.
     * @return Все позиции указанного заказа.
     */

    public List<OrderedConfectioneryDto> findAll (Long id) {
        List<OrderedConfectioneryDto> result = new ArrayList<>();
        for (OrderedConfectionery orderedConfectionery : id == null
                ? orderedConfectioneryRepository.findAll() : orderedConfectioneryRepository.findByOrders_Id(id)) {
            result.add(OrderedConfectioneryDto.fromEntity(orderedConfectionery));
        }
        return result;
    }

    /**
     * Обновляет перемнные позиции заказа.
     * @param orderedConfectioneryDto Новые параметры сущности.
     * @return Возвращает запись OrderedConfectionery.
     */
    public OrderedConfectioneryDto update (OrderedConfectioneryDto orderedConfectioneryDto) {
        OrderedConfectionery orderedConfectionery = orderedConfectioneryRepository.findById(orderedConfectioneryDto.getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderedConfectionery = OrderedConfectioneryDto.toEntity(orderedConfectioneryDto);
        orderedConfectionery.setOrders(ordersRepository.getReferenceById(orderedConfectioneryDto.getOrdersId()));
        orderedConfectionery.setConfectioneryName(flowSheetRepository.findByCandyShop_IdAndConfectioneryNameIgnoreCase(
                ordersRepository.getReferenceById(orderedConfectioneryDto.getOrdersId()).getCandyShop().getId(),
                orderedConfectioneryDto.getConfectioneryName()
        ));
        return OrderedConfectioneryDto.fromEntity(orderedConfectioneryRepository.save(orderedConfectionery));
    }

    /**
     * Создание новой записи сущности OrderedConfectionery.
     * @param ordersId Идентификатор заказа.
     * @param orderedConfectioneryDto Параметры сущности.
     * @return Возвращает запись OrderedConfectionery.
     */
    public OrderedConfectioneryDto create (long ordersId, OrderedConfectioneryDto orderedConfectioneryDto) {
        OrderedConfectionery orderedConfectionery = OrderedConfectioneryDto.toEntity(orderedConfectioneryDto);
        orderedConfectionery.setOrders(ordersRepository.findById(ordersId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        orderedConfectionery.setConfectioneryName(flowSheetRepository.findByCandyShop_IdAndConfectioneryNameIgnoreCase(
                ordersRepository.getReferenceById(ordersId).getCandyShop().getId(),
                orderedConfectioneryDto.getConfectioneryName()
        ));
        return OrderedConfectioneryDto.fromEntity(orderedConfectioneryRepository.save(orderedConfectionery));
    }

    /**
     * Удаление записи сущности OrderedConfectionery.
     * @param id Идентификатор ингредиента.
     */
    public void delete (long id) {
        if (orderedConfectioneryRepository.existsById(id)) {
            orderedConfectioneryRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
