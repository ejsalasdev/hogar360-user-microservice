package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class RequiredAgeValidator implements UserDataValidator {
    
    private UserDataValidator nextValidator;
    @Override
    public void validate(UserModel userModel) {
        if (userModel.getBirthDate() != null) {
            LocalDate now = LocalDate.now(ZoneId.of("America/Bogota"));
            Period period = Period.between(userModel.getBirthDate(), now);
            if (period.getYears() < 18) {
                throw new UnderAgeException("El usuario debe ser mayor de edad.");
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
