package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.RequiredFieldsException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class RequiredFieldsValidator implements UserDataValidator {

    private UserDataValidator nextValidator;

    @Override
    public void validate(UserModel userModel) {
        if (userModel.getName() == null || userModel.getName().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, "name")
            );
        }
        if (userModel.getLastName() == null || userModel.getLastName().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, "lastName")
            );
        }
        if (userModel.getDocumentId() == null || userModel.getDocumentId().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, "documentId")
            );
        }
        if (userModel.getPhoneNumber() == null || userModel.getPhoneNumber().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, "phoneNumber")
            );
        }
        if (userModel.getBirthDate() == null) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, "birthDate")
            );
        }
        if (userModel.getEmail() == null || userModel.getEmail().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, "email")
            );
        }
        if (userModel.getPassword() == null || userModel.getPassword().trim().isEmpty()) {
            throw new RequiredFieldsException(
                    String.format(DomainExceptionsConstants.REQUIRED_FIELD_MESSAGE, "password")
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
