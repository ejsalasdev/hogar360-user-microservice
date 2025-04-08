package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class StringOnlyValidatorTest {

    private UserModel userModel;

    @BeforeEach
    void setUp() {
        userModel = new UserModel(
                null,
                "Test",
                "User",
                "123",
                "123",
                LocalDate.now(),
                "test@test.com",
                "pass",
                null);
    }

    @Test
    void validate_nameContainsOnlyLettersAndSpaces_doesNotThrowException() {
        StringOnlyValidator validator = new StringOnlyValidator("name");
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @Test
    void validate_nameContainsNumbers_throwsInvalidElementFormatException() {
        userModel.setName("Test1");
        StringOnlyValidator validator = new StringOnlyValidator("name");
        InvalidElementFormatException exception = assertThrows(InvalidElementFormatException.class, () -> validator.validate(userModel));
        assertEquals("Field name 'Test1' contains invalid characters. Only letters and space are allowed.", exception.getMessage());
    }

    @Test
    void validate_lastNameContainsInvalidChars_throwsInvalidElementFormatException() {
        userModel.setLastName("User-");
        StringOnlyValidator validator = new StringOnlyValidator("lastName");
        InvalidElementFormatException exception = assertThrows(InvalidElementFormatException.class, () -> validator.validate(userModel));
        assertEquals("Field lastName 'User-' contains invalid characters. Only letters and space are allowed.", exception.getMessage());
    }

}