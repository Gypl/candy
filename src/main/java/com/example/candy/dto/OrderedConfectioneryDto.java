package com.example.candy.dto;

import com.example.candy.entity.FlowSheet;
import com.example.candy.entity.OrderedConfectionery;
import com.example.candy.entity.Orders;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.candy.entity.OrderedConfectionery} entity
 */
@Data
@Getter
@Setter
public class OrderedConfectioneryDto implements Serializable {
    private Long id;
    private FlowSheet confectioneryName;
    private Integer number;
    private Long ordersId;

    public static OrderedConfectioneryDto fromEntity(OrderedConfectionery orderedConfectionery) {
        OrderedConfectioneryDto dto = new OrderedConfectioneryDto();
        dto.setId(orderedConfectionery.getId());
        dto.setConfectioneryName(orderedConfectionery.getConfectioneryName());
        dto.setNumber(orderedConfectionery.getNumber());
        dto.setOrdersId(orderedConfectionery.getOrders().getId());
        return dto;
    }

    public static OrderedConfectionery toEntity (OrderedConfectioneryDto dto) {
        OrderedConfectionery orderedConfectionery = new OrderedConfectionery();
        orderedConfectionery.setId(dto.getId());
        orderedConfectionery.setConfectioneryName(dto.getConfectioneryName());
        orderedConfectionery.setNumber(dto.getNumber());
        return orderedConfectionery;
    }
}