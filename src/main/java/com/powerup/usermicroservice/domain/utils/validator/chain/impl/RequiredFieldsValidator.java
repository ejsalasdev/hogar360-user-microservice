package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.RequiredFieldsException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class RequiredFieldsValidator implements UserDataValidator {

    private UserDataValidator nextValidator;

    @Override
    public void validate(UserModel userModel) {
        if (userModel.getName() == null || userModel.getName().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, UserConstants.NAME_FIELD)
            );
        }
        if (userModel.getLastName() == null || userModel.getLastName().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, UserConstants.LAST_NAME_FIELD)
            );
        }
        if (userModel.getDocumentId() == null || userModel.getDocumentId().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, UserConstants.DOCUMENT_ID_FIELD)
            );
        }
        if (userModel.getPhoneNumber() == null || userModel.getPhoneNumber().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, UserConstants.PHONE_NUMBER_FIELD)
            );
        }
        if (userModel.getBirthDate() == null) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, UserConstants.BIRTH_DATE_FIELD)
            );
        }
        if (userModel.getEmail() == null || userModel.getEmail().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, UserConstants.EMAIL_FIELD)
            );
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, UserConstants.PASSWORD_FIELD)
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
