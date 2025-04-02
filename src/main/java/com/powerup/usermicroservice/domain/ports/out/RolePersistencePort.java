package com.powerup.usermicroservice.domain.ports.out;

import com.powerup.usermicroservice.domain.model.RoleModel;

import java.util.Optional;

public interface RolePersistencePort {
    
    Optional<RoleModel> getRoleByid(Long id);
    Optional<RoleModel> getRoleByName(String name);
}
