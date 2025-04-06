package com.powerup.usermicroservice.infrastructure.adapters.persistence;

import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.ports.out.UserPersistencePort;
import com.powerup.usermicroservice.infrastructure.entities.UserEntity;
import com.powerup.usermicroservice.infrastructure.mappers.UserEntityMapper;
import com.powerup.usermicroservice.infrastructure.repositories.mysql.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {
    
    private final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    
    @Override
    public void save(UserModel userModel) {
        UserEntity userEntity = userEntityMapper.modelToEntity(userModel);
        userRepository.save(userEntity);
    }

    @Override
    public Optional<UserModel> getUserByDocumentId(String documentId) {
        return userRepository.findByDocumentId(documentId).map(userEntityMapper::entityToModel);
    }
}
