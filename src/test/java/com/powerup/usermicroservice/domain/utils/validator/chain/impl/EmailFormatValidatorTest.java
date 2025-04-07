package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EmailFormatValidatorTest {

    private EmailFormatValidator validator;
    private UserModel userModel;

    @BeforeEach
    void setUp() {
        validator = new EmailFormatValidator();
        userModel = new UserModel(null, "Test", "User", "123", "123", null, null, "pass", null);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"test@example.com", "user.name@subdomain.example.co.uk", "long-email-address_with.underscores+plus.signs@and.hyphens-example.com"})
    void validate_validEmailFormat_doesNotThrowException(String validEmail) {
        userModel.setEmail(validEmail);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @ParameterizedTest
    @ValueSource(strings = {"invalid-email", "test@example", "@example.com", "test@", "test@.com", "test@example..com", "test@example.c"})
    void validate_invalidEmailFormat_throwsInvalidElementFormatException(String invalidEmail) {
        userModel.setEmail(invalidEmail);
        InvalidElementFormatException exception = assertThrows(InvalidElementFormatException.class, () -> validator.validate(userModel));
        assertEquals(String.format(DomainExceptionsConstants.EMAIL_INVALID_FORMAT_MESSAGE), exception.getMessage());
    }
}