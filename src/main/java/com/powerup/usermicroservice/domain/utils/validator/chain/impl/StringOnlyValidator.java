package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOnlyValidator implements UserDataValidator {

    private UserDataValidator nextValidator;
    private final String fieldName;

    public StringOnlyValidator(String fieldName) {
        this.fieldName = fieldName;
    }

    @Override
    public void validate(UserModel userModel) {
        String value = "";
        if (fieldName.equals("name")) {
            value = userModel.getName();
        } else if (fieldName.equals("lastName")) {
            value = userModel.getLastName();
        }

        if (value != null && !value.trim().isEmpty()) {
            Pattern pattern = Pattern.compile(UserConstants.ONLY_STRING_REGEX);
            Matcher matcher = pattern.matcher(value);
            if (!matcher.matches()) {
                throw new InvalidElementFormatException(
                        String.format(DomainExceptionsConstants.STRING_INPUT_FORMAT_ERROR_MESSAGE, fieldName, value)
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
