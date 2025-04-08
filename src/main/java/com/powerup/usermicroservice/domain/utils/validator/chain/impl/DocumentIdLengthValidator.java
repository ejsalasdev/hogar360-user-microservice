package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementLengthException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;

public class DocumentIdLengthValidator implements UserDataValidator {

    private UserDataValidator nextValidator;

    @Override
    public void validate(UserModel userModel) {
        String documentId = userModel.getDocumentId();
        if (documentId != null && !documentId.trim().isEmpty() &&
                (documentId.length() < UserConstants.DOCUMENT_ID_MIN_LENGTH ||
                        documentId.length() > UserConstants.DOCUMENT_ID_MAX_LENGTH)) {
            throw new InvalidElementLengthException(
                    String.format(DomainExceptionsConstants.DOCUMENT_ID_INVALID_LENGTH_MESSAGE)
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
