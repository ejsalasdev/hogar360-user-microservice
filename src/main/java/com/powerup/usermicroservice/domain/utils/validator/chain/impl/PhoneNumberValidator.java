package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class PhoneNumberValidator implements UserDataValidator {

    private UserDataValidator nextValidator;

    @Override
    public void validate(UserModel userModel) {
        if (
                userModel.getPhoneNumber() != null && !userModel.getPhoneNumber().trim().isEmpty() &&
                        !userModel.getPhoneNumber().matches(UserConstants.PHONE_NUMBER_FORMAT_REGEX)
        ) {
            throw new InvalidElementFormatException(
                    String.format(DomainExceptionsConstants.PHONE_NUMBER_INVALID_FORMAT_MESSAGE)
            );
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
