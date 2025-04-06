package com.powerup.usermicroservice.domain.utils.constants;

import com.powerup.usermicroservice.domain.model.RoleModel;

public class UserConstants {
    
    public static final RoleModel SELLER_ROLE = new RoleModel(1L, "seller", "User with seller role");
    
    private UserConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
