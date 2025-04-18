package com.powerup.usermicroservice.domain.ports.out;

import com.powerup.usermicroservice.domain.model.UserModel;

import java.util.Optional;

public interface UserPersistencePort {
    
    void save(UserModel userModel);
    Optional<UserModel> getUserByDocumentId(String documentId);

    Optional<UserModel> getUserByEmail(String email);
}
