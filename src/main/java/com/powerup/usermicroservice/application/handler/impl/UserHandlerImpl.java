package com.powerup.usermicroservice.application.handler.impl;

import com.powerup.usermicroservice.application.dto.request.SaveUserRequest;
import com.powerup.usermicroservice.application.dto.response.SaveUserResponse;
import com.powerup.usermicroservice.application.handler.UserHandler;
import com.powerup.usermicroservice.application.mappers.UserRequestMapper;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.ports.in.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements UserHandler {
    
    private final UserRequestMapper userRequestMapper;
    private final UserServicePort userServicePort;

    @Override
    public SaveUserResponse save(SaveUserRequest saveUserRequest) {
        UserModel userModel = userRequestMapper.requestToModel(saveUserRequest);
        userServicePort.save(userModel);
        return new SaveUserResponse("User created successfully", LocalDateTime.now());
    }
}
