package com.powerup.usermicroservice.domain.utils.validator;

import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.validator.chain.UserDataValidator;
import com.powerup.usermicroservice.domain.utils.validator.chain.impl.*;

public class UserValidatorChain {
    
    private final UserDataValidator firstValidator;

    public UserValidatorChain() {
        
        UserDataValidator requiredFieldsValidator = new RequiredFieldsValidator();
        UserDataValidator stringOnlyInNameValidator = new StringOnlyValidator("name");
        UserDataValidator stringOnlyInLastNameValidator = new StringOnlyValidator("lastName");
        UserDataValidator documentIdValidator = new DocumentIdValidator();
        UserDataValidator documentIdLengthValidator = new DocumentIdLengthValidator();
        UserDataValidator phoneNumberValidator = new PhoneNumberValidator();
        UserDataValidator phoneNumberLengthValidator = new PhoneNumberLengthValidator();
        UserDataValidator requiredAgeValidator = new RequiredAgeValidator();
        UserDataValidator emailFormatValidator = new EmailFormatValidator();
        
        requiredFieldsValidator.setNextValidator(stringOnlyInNameValidator);
        stringOnlyInNameValidator.setNextValidator(stringOnlyInLastNameValidator);
        stringOnlyInLastNameValidator.setNextValidator(documentIdValidator);
        documentIdValidator.setNextValidator(documentIdLengthValidator);
        documentIdLengthValidator.setNextValidator(phoneNumberValidator);
        phoneNumberValidator.setNextValidator(phoneNumberLengthValidator);
        phoneNumberLengthValidator.setNextValidator(requiredAgeValidator);
        requiredAgeValidator.setNextValidator(emailFormatValidator);
        
        this.firstValidator = requiredFieldsValidator;
    }

    public void validate(UserModel userModel) {
        if (firstValidator != null) {
            firstValidator.validate(userModel);
        }
    }
}
