package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFormatValidator implements UserDataValidator {
    
    private UserDataValidator nextValidator;
    @Override
    public void validate(UserModel userModel) {

        if (userModel.getEmail() != null && !userModel.getEmail().trim().isEmpty()) {
            String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(userModel.getEmail());
            if (!matcher.matches()) {
                throw new InvalidElementFormatException("El formato del correo electrónico no es válido.");
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
