package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.InvalidElementFormatException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DocumentIdValidatorTest {

    private DocumentIdValidator validator;
    private UserModel userModel;

    @BeforeEach
    void setUp() {
        validator = new DocumentIdValidator();
        userModel = new UserModel(null, "Test", "User", null, "123", null, "test@test.com", "pass", null);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"12345", "000", "9876543210"})
    void validate_validDocumentId_doesNotThrowException(String validDocumentId) {
        userModel.setDocumentId(validDocumentId);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @ParameterizedTest
    @ValueSource(strings = {"123a", "123-", "123 4", "a123", "-123", "1 23"})
    void validate_documentIdContainsNonNumericCharacters_throwsInvalidElementFormatException(String invalidDocumentId) {
        userModel.setDocumentId(invalidDocumentId);
        InvalidElementFormatException exception = assertThrows(InvalidElementFormatException.class, () -> validator.validate(userModel));
        assertEquals(String.format(DomainExceptionsConstants.DOCUMENT_ID_NOT_NUMERIC_MESSAGE), exception.getMessage());
    }
}