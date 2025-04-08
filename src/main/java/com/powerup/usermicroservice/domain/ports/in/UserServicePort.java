package com.powerup.usermicroservice.domain.ports.in;

import com.powerup.usermicroservice.domain.model.UserModel;

public interface UserServicePort {
    
    void save(UserModel userModel);
}
