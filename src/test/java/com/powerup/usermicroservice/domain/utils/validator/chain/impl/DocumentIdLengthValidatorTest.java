package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementLengthException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DocumentIdLengthValidatorTest {

    private DocumentIdLengthValidator validator;
    private UserModel userModel;

    @BeforeEach
    void setUp() {
        validator = new DocumentIdLengthValidator();
        userModel = new UserModel(null, "Test", "User", null, "123", null, "test@test.com", "pass", null);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"12345678", "123456789", "1234567890"})
    void validate_documentIdLengthIsWithinRange_doesNotThrowException(String validDocumentId) {
        userModel.setDocumentId(validDocumentId);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234567", "12345678901"})
    void validate_documentIdLengthIsOutOfRange_throwsInvalidElementLengthException(String invalidDocumentId) {
        userModel.setDocumentId(invalidDocumentId);
        InvalidElementLengthException exception = assertThrows(InvalidElementLengthException.class, () -> validator.validate(userModel));
        assertEquals(String.format(DomainExceptionsConstants.DOCUMENT_ID_INVALID_LENGTH_MESSAGE), exception.getMessage());
    }
}