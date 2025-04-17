package com.powerup.usermicroservice.application.handler.impl;

import com.powerup.usermicroservice.application.dto.request.LoginRequest;
import com.powerup.usermicroservice.application.dto.response.LoginResponse;
import com.powerup.usermicroservice.application.handler.AuthHandler;
import com.powerup.usermicroservice.infrastructure.security.jwt.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthHandlerImpl implements AuthHandler {
    
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    
    @Override
    public LoginResponse login(LoginRequest request) {
        
        String username = request.email();
        String password = request.password();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String accessToken = jwtUtils.createToken(authentication);

        return new LoginResponse(accessToken);
    }
}
