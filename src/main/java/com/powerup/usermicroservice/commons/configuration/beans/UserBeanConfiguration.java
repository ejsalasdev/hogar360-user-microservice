package com.powerup.usermicroservice.commons.configuration.beans;

import com.powerup.usermicroservice.domain.ports.in.UserServicePort;
import com.powerup.usermicroservice.domain.ports.out.UserPersistencePort;
import com.powerup.usermicroservice.domain.usecases.UserUseCase;
import com.powerup.usermicroservice.infrastructure.adapters.persistence.UserPersistenceAdapter;
import com.powerup.usermicroservice.infrastructure.mappers.UserEntityMapper;
import com.powerup.usermicroservice.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class UserBeanConfiguration {

    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;
    
    @Bean
    public UserPersistencePort userPersistencePort() {
        return new UserPersistenceAdapter(userRepository, userEntityMapper);
    }
    
    @Bean
    public UserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), passwordEncoder);
    }
}
