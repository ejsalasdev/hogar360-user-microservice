package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class DocumentIdValidator implements UserDataValidator {

    private UserDataValidator nextValidator;

    @Override
    public void validate(UserModel userModel) {
        if (userModel.getDocumentId() != null && !userModel.getDocumentId().trim().isEmpty() &&
                !userModel.getDocumentId().matches(UserConstants.ONLY_NUMERIC_REGEX)) {
            throw new InvalidElementFormatException(
                    String.format(DomainExceptionsConstants.DOCUMENT_ID_NOT_NUMERIC_MESSAGE)
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
