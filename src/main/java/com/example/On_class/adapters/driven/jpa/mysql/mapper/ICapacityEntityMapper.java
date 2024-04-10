package com.example.On_class.adapters.driven.jpa.mysql.mapper;

import com.example.On_class.adapters.driven.jpa.mysql.entity.CapacityEntity;
import com.example.On_class.domain.model.Capacity;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface ICapacityEntityMapper {
    CapacityEntity toEntity(Capacity capacity);
    Capacity toModel(CapacityEntity entity);
    List<Capacity> toModelList(List<CapacityEntity> capacityEntities);
}