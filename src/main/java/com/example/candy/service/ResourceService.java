package com.example.candy.service;

import com.example.candy.dto.ResourceDto;
import com.example.candy.entity.Resource;
import com.example.candy.repository.CandyShopRepository;
import com.example.candy.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceService {
    private final ResourceRepository resourceRepository;
    private final CandyShopRepository candyShopRepository;

    public long count() {return resourceRepository.count();}

    /**
     * Возвращает все ресурсы для сущности кондитерская.
     * @param name Название кондитерской которой принадлежат ресурсы.
     * @return Все ресурсы указанной кондитерской.
     */

    public List<ResourceDto> findAll (String name) {
        List<ResourceDto> result = new ArrayList<>();
        for (Resource resource : name == null
                ? resourceRepository.findAll() : resourceRepository.findByCandyShop_NameIgnoreCase(name)) {
            result.add(ResourceDto.fromEntity(resource));
        }
        return result;
    }

    /**
     * Обновляет перемнные тех. карты.
     * @param resourceDto Новые параметры сущности.
     * @return Возвращает запись Resource.
     */
    public ResourceDto update (ResourceDto resourceDto) {
        Resource resource = resourceRepository.findById(resourceDto.getId()).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        resource = ResourceDto.toEntity(resourceDto);
        return ResourceDto.fromEntity(resourceRepository.save(resource));
    }

    /**
     * Создание новой записи сущности Resource.
     * @param candyShopId Идентификатор кондитерской.
     * @param resourceDto Параметры сущности.
     * @return Возвращает запись Resource.
     */
    public ResourceDto create (long candyShopId, ResourceDto resourceDto) {
        Resource resource = ResourceDto.toEntity(resourceDto);
        resource.setCandyShop(candyShopRepository.findById(candyShopId).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
        return ResourceDto.fromEntity(resourceRepository.save(resource));
    }

    /**
     * Удаление записи сущности Resource.
     * @param id Идентификатор ингредиента.
     */
    public void delete (long id) {
        if (resourceRepository.existsById(id)) {
            resourceRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
