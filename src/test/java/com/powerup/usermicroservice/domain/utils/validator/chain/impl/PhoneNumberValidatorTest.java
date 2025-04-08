package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator validator;
    private UserModel userModel;

    @BeforeEach
    void setUp() {
        validator = new PhoneNumberValidator();
        userModel = new UserModel(null, "Test", "User", "123", null, null, "test@test.com", "pass", null);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"1234567890", "+573001234567", "0", "+0"})
    void validate_validPhoneNumberFormat_doesNotThrowException(String validPhoneNumber) {
        userModel.setPhoneNumber(validPhoneNumber);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "123-456", "123 45", "+abc", "123a"})
    void validate_invalidPhoneNumberFormat_throwsInvalidElementFormatException(String invalidPhoneNumber) {
        userModel.setPhoneNumber(invalidPhoneNumber);
        InvalidElementFormatException exception = assertThrows(InvalidElementFormatException.class, () -> validator.validate(userModel));
        assertEquals(String.format(DomainExceptionsConstants.PHONE_NUMBER_INVALID_FORMAT_MESSAGE), exception.getMessage());
    }
}