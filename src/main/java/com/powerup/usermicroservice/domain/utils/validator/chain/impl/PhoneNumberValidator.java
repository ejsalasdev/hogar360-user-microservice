package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class PhoneNumberValidator implements UserDataValidator {

    private UserDataValidator nextValidator;

    @Override
    public void validate(UserModel userModel) {
        if (
                userModel.getPhoneNumber() != null && !userModel.getPhoneNumber().trim().isEmpty() &&
                        (userModel.getPhoneNumber().length() > 13 || !userModel.getPhoneNumber().matches("^\\+?\\d+$"))
        ) {
            throw new InvalidElementFormatException("El formato del número de celular no es válido (máximo 13 caracteres, puede incluir +).");
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
