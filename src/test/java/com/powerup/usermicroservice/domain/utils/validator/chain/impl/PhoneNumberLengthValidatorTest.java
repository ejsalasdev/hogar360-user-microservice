package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementLengthException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberLengthValidatorTest {

    private PhoneNumberLengthValidator validator;
    private UserModel userModel;

    @BeforeEach
    void setUp() {
        validator = new PhoneNumberLengthValidator();
        userModel = new UserModel(null, "Test", "User", "123", null, null, "test@test.com", "pass", null);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1234567890", "12345678901", "123456789012", "1234567890123"})
    void validate_phoneNumberLengthIsWithinRange_doesNotThrowException(String validPhoneNumber) {
        userModel.setPhoneNumber(validPhoneNumber);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456789", "12345678901234"})
    void validate_phoneNumberLengthIsOutOfRange_throwsInvalidElementLengthException(String invalidPhoneNumber) {
        userModel.setPhoneNumber(invalidPhoneNumber);
        InvalidElementLengthException exception = assertThrows(InvalidElementLengthException.class, () -> validator.validate(userModel));
        assertEquals(String.format(DomainExceptionsConstants.PHONE_NUMBER_INVALID_LENGTH_MESSAGE), exception.getMessage());
    }
}