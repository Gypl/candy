package com.example.candy.dto;

import com.example.candy.entity.CandyShop;
import com.example.candy.entity.Confectionery;
import com.example.candy.entity.FlowSheet;
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
    private FlowSheet confectioneryName;
    private Integer number;
    private CandyShop candyShop;

    public static ConfectioneryDto fromEntity (Confectionery confectionery) {
        ConfectioneryDto dto = new ConfectioneryDto();
        dto.setId(confectionery.getId());
        dto.setConfectioneryName(confectionery.getConfectioneryName());
        dto.setNumber(confectionery.getNumber());
        dto.setCandyShop(confectionery.getCandyShop());
        return dto;
    }

    public static Confectionery toEntity (ConfectioneryDto dto) {
        Confectionery confectionery = new Confectionery();
        confectionery.setId(dto.getId());
        confectionery.setConfectioneryName(dto.getConfectioneryName());
        confectionery.setNumber(dto.getNumber());
        confectionery.setCandyShop(dto.getCandyShop());
        return confectionery;
    }
}