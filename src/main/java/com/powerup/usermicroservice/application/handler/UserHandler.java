package com.powerup.usermicroservice.application.handler;

import com.powerup.usermicroservice.application.dto.request.SaveUserRequest;
import com.powerup.usermicroservice.application.dto.response.SaveUserResponse;

public interface UserHandler {
    
    SaveUserResponse save(SaveUserRequest saveUserRequest);
}
