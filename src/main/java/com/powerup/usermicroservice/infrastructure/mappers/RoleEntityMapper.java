package com.powerup.usermicroservice.infrastructure.mappers;

import com.powerup.usermicroservice.domain.model.RoleModel;
import com.powerup.usermicroservice.infrastructure.entities.RolEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleEntityMapper {
    
    RolEntity modelToEntity(RoleModel roleModel);
    RoleModel entityToModel(RolEntity rolEntity);
}
