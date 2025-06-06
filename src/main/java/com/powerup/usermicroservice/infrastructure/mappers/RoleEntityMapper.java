package com.powerup.usermicroservice.infrastructure.mappers;

import org.mapstruct.Mapper;

import com.powerup.usermicroservice.domain.model.RoleModel;
import com.powerup.usermicroservice.infrastructure.entities.RolEntity;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {

    RolEntity modelToEntity(RoleModel roleModel);
    
    RoleModel entityToModel(RolEntity rolEntity);
}
