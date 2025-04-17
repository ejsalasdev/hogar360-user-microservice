package com.powerup.usermicroservice.infrastructure.repositories.mysql;

import com.powerup.usermicroservice.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByDocumentId(String documentId);

    Optional<UserEntity> findByEmail(String email);
}
