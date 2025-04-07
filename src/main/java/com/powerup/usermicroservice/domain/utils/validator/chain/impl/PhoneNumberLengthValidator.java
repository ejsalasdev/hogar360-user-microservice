package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementLengthException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class PhoneNumberLengthValidator implements UserDataValidator {

    private UserDataValidator nextValidator;

    @Override
    public void validate(UserModel userModel) {
        String phoneNumber = userModel.getPhoneNumber();
        
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            if (phoneNumber.length() < UserConstants.PHONE_NUMBER_MIN_LENGTH ||
                    phoneNumber.length() > UserConstants.PHONE_NUMBER_MAX_LENGTH) {
                throw new InvalidElementLengthException(
                        String.format(DomainExceptionsConstants.PHONE_NUMBER_INVALID_LENGTH_MESSAGE)
                );
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
