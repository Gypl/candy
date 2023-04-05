package com.example.candy.dto;

import com.example.candy.entity.CandyShop;
import com.example.candy.entity.OrderedConfectionery;
import com.example.candy.entity.Orders;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.example.candy.entity.Orders} entity
 */
@Data
@Getter
@Setter
public class OrdersDto implements Serializable {
    private Long id;
    private Long orderNumber;
    private List<OrderedConfectioneryDto> orderedConfectioneries;
    private Boolean startReady;
    private Boolean serveReady;
    private CandyShop candyShop;

    public static OrdersDto fromEntity (Orders orders) {
        OrdersDto dto = new OrdersDto();
        dto.setId(orders.getId());
        dto.setOrderNumber(orders.getOrderNumber());
        dto.setStartReady(orders.getStartReady());
        dto.setServeReady(orders.getServeReady());
        dto.setCandyShop(orders.getCandyShop());
        List<OrderedConfectioneryDto> orderedConfectioneries = new ArrayList<>();
        dto.setOrderedConfectioneries(orderedConfectioneries);
        for (OrderedConfectionery orderedConfectionery : orders.getOrderedConfectioneries()) {
            orderedConfectioneries.add(OrderedConfectioneryDto.fromEntity(orderedConfectionery));
        }
        return dto;
    }

    public static Orders toEntity (OrdersDto dto) {
        Orders orders = new Orders();
        orders.setId(dto.getId());
        orders.setOrderNumber(dto.getOrderNumber());
        orders.setStartReady(dto.getStartReady());
        orders.setServeReady(dto.getServeReady());
        orders.setCandyShop(dto.getCandyShop());
        orders.setOrderedConfectioneries(new ArrayList<>());
        return orders;
    }
}