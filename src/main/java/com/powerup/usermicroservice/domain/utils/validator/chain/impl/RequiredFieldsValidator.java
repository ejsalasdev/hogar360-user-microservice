package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.RequiredFieldsException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class RequiredFieldsValidator implements UserDataValidator {
    
    private UserDataValidator nextValidator;
    @Override
    public void validate(UserModel userModel) {
        if (userModel.getName() == null || userModel.getName().trim().isEmpty()) {
            throw new RequiredFieldsException("El nombre es obligatorio.");
        }
        if (userModel.getLastName() == null || userModel.getLastName().trim().isEmpty()) {
            throw new RequiredFieldsException("El apellido es obligatorio.");
        }
        if (userModel.getDocumentId() == null || userModel.getDocumentId().trim().isEmpty()) {
            throw new RequiredFieldsException("El documento de identidad es obligatorio.");
        }
        if (userModel.getPhoneNumber() == null || userModel.getPhoneNumber().trim().isEmpty()) {
            throw new RequiredFieldsException("El número de celular es obligatorio.");
        }
        if (userModel.getBirthDate() == null) {
            throw new RequiredFieldsException("La fecha de nacimiento es obligatoria.");
        }
        if (userModel.getEmail() == null || userModel.getEmail().trim().isEmpty()) {
            throw new RequiredFieldsException("El correo electrónico es obligatorio.");
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().isEmpty()) {
            throw new RequiredFieldsException("La clave es obligatoria.");
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
