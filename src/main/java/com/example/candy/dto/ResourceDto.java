package com.example.candy.dto;

import com.example.candy.entity.CandyShop;
import com.example.candy.entity.Resource;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.example.candy.entity.Resource} entity
 */
@Data
@Getter
@Setter
public class ResourceDto implements Serializable {
    private Long id;
    private String resourceName;
    private Double amount;
    private String dimension;
    private Long shopId;

    public static ResourceDto fromEntity (Resource resource) {
        ResourceDto dto = new ResourceDto();
        dto.setId(resource.getId());
        dto.setResourceName(resource.getResourceName());
        dto.setAmount(resource.getAmount());
        dto.setDimension(resource.getDimension());
        dto.setShopId(resource.getCandyShop().getId());
        return dto;
    }

    public static Resource toEntity (ResourceDto dto) {
        Resource resource = new Resource();
        resource.setId(dto.getId());
        resource.setResourceName(dto.getResourceName());
        resource.setAmount(dto.getAmount());
        resource.setDimension(dto.getDimension());
        return resource;
    }
}