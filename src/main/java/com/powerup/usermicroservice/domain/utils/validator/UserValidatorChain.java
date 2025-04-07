package com.powerup.usermicroservice.domain.utils.validator;

import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;
import com.powerup.usermicroservice.domain.utils.validator.chain.impl.*;

public class UserValidatorChain {
    
    private UserDataValidator firstValidator;

    public UserValidatorChain() {
        
        UserDataValidator requiredFieldsValidator = new RequiredFieldsValidator();
        UserDataValidator documentIdValidator = new DocumentIdValidator();
        UserDataValidator phoneNumberValidator = new PhoneNumberValidator();
        UserDataValidator requiredAgeValidator = new RequiredAgeValidator();
        UserDataValidator emailFormatValidator = new EmailFormatValidator();
        
        requiredFieldsValidator.setNextValidator(documentIdValidator);
        documentIdValidator.setNextValidator(phoneNumberValidator);
        phoneNumberValidator.setNextValidator(requiredAgeValidator);
        requiredAgeValidator.setNextValidator(emailFormatValidator);
        
        this.firstValidator = requiredFieldsValidator;
    }

    public void validate(UserModel userModel) {
        if (firstValidator != null) {
            firstValidator.validate(userModel);
        }
    }
}
