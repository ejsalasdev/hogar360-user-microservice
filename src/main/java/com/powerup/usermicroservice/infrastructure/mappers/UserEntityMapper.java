package com.powerup.usermicroservice.infrastructure.mappers;

import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.infrastructure.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    
    @Mapping(source = "role", target = "role")
    UserEntity modelToEntity(UserModel userModel);
    
    @Mapping(source = "role", target = "role")
    UserModel entityToModel(UserEntity userEntity);
}
