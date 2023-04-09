package com.example.candy.dto;

import com.example.candy.entity.CandyShop;
import com.example.candy.entity.Confectionery;
import com.example.candy.entity.FlowSheet;
import com.example.candy.repository.FlowSheetRepository;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.candy.entity.Confectionery} entity
 */
@Data
@Getter
@Setter
public class ConfectioneryDto implements Serializable {
    private Long id;
    private String confectioneryName;
    private Integer number;
    private Long candyShopId;

    public static ConfectioneryDto fromEntity (Confectionery confectionery) {
        ConfectioneryDto dto = new ConfectioneryDto();
        dto.setId(confectionery.getId());
        dto.setConfectioneryName(confectionery.getConfectioneryName().getConfectioneryName());
        dto.setNumber(confectionery.getNumber());
        dto.setCandyShopId(confectionery.getCandyShop().getId());
        return dto;
    }

    public static Confectionery toEntity (ConfectioneryDto dto) {
        Confectionery confectionery = new Confectionery();
        confectionery.setId(dto.getId());
        confectionery.setNumber(dto.getNumber());
        return confectionery;
    }
}