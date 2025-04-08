package com.powerup.usermicroservice.domain.utils.validator.chain;

import com.powerup.usermicroservice.domain.model.UserModel;

public interface UserDataValidator {
    
    void validate(UserModel userModel);
    void setNextValidator(UserDataValidator nextValidator);
}
