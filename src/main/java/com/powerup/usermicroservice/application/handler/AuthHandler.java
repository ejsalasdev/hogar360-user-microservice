package com.powerup.usermicroservice.application.handler;

import com.powerup.usermicroservice.application.dto.request.LoginRequest;
import com.powerup.usermicroservice.application.dto.response.LoginResponse;

public interface AuthHandler {
    
    LoginResponse login(LoginRequest loginRequest);
}
