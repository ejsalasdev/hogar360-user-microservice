package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class DocumentIdValidator implements UserDataValidator {
    
    private UserDataValidator nextValidator;
    @Override
    public void validate(UserModel userModel) {
        if (userModel.getDocumentId() != null && !userModel.getDocumentId().trim().isEmpty()) {
            if (!userModel.getDocumentId().matches("^\\d+$")) {
                throw new InvalidElementFormatException("El documento de identidad debe ser únicamente numérico.");
            }
        }

        if (nextValidator != null) {
            nextValidator.validate(userModel);
        }
    }

    @Override
    public void setNextValidator(UserDataValidator nextValidator) {
        this.nextValidator = nextValidator;
    }
}
