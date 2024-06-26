package com.example.on_class.adapters.driven.jpa.mysql.mapper;

import com.example.on_class.adapters.driven.jpa.mysql.entity.VersionEntity;
import com.example.on_class.domain.model.Version;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IVersionEntityMapper {
    VersionEntity toEntity(Version version);
    Version toModel(VersionEntity entity);
    List<Version> toModelList(List<VersionEntity> versionEntities);
}
