package com.powerup.usermicroservice.application.mappers;

import com.powerup.usermicroservice.application.dto.request.SaveUserRequest;
import com.powerup.usermicroservice.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    
    UserModel requestToModel(SaveUserRequest saveUserRequest);
}
