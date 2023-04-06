package com.example.candy.service;

import com.example.candy.dto.OrdersDto;
import com.example.candy.entity.Orders;
import com.example.candy.repository.CandyShopRepository;
import com.example.candy.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersService {
        private final OrdersRepository ordersRepository;
        private final CandyShopRepository candyShopRepository;

        public long count() {return ordersRepository.count();}

        /**
         * Возвращает все заказы для указанной сущности кондитерская.
         * @param name Название кондитерской которой принадлежат заказы.
         * @return Все заказы указанной кондитерской.
         */

        public List<OrdersDto> findAll (String name) {
            List<OrdersDto> result = new ArrayList<>();
            for (Orders orders : name == null
                    ? ordersRepository.findAll() : ordersRepository.findByCandyShop_NameIgnoreCase(name)) {
                result.add(OrdersDto.fromEntity(orders));
            }
            return result;
        }

        /**
         * Обновляет перемнные заказы.
         * @param ordersDto Новые параметры сущности.
         * @return Возвращает запись Orders.
         */
        public OrdersDto update (OrdersDto ordersDto) {
            Orders orders = ordersRepository.findById(ordersDto.getId()).orElseThrow(()
                    -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            return OrdersDto.fromEntity(ordersRepository.save(orders));
        }

        /**
         * Создание новой записи сущности Orders.
         * @param candyShopId Идентификатор кондитерской.
         * @param ordersDto Параметры сущности.
         * @return Возвращает запись Orders.
         */
        public OrdersDto create (long candyShopId, OrdersDto ordersDto) {
            Orders orders = OrdersDto.toEntity(ordersDto);
            orders.setCandyShop(candyShopRepository.findById(candyShopId).orElseThrow(()
                    -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
            return OrdersDto.fromEntity(ordersRepository.save(orders));
        }

        /**
         * Удаление записи сущности Orders.
         * @param id Идентификатор заказа.
         */
        public void delete (long id) {
            if (ordersRepository.existsById(id)) {
                ordersRepository.deleteById(id);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        }
}
