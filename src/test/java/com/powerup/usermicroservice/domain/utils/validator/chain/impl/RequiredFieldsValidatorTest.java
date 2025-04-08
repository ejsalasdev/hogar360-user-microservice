package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.RequiredFieldsException;
import com.powerup.usermicroservice.domain.model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RequiredFieldsValidatorTest {

    private RequiredFieldsValidator validator;
    private UserModel userModel;

    @BeforeEach
    void setUp() {
        validator = new RequiredFieldsValidator();
        userModel = new UserModel(null, "Test", "User", "123", "123", LocalDate.now(), "test@test.com", "pass", null);
    }

    @Test
    void validate_allRequiredFieldsPresent_doesNotThrowException() {
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @Test
    void validate_nameIsNull_throwsRequiredFieldsException() {
        userModel.setName(null);
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'name' is necessary", exception.getMessage());
    }

    @Test
    void validate_nameIsEmpty_throwsRequiredFieldsException() {
        userModel.setName("");
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'name' is necessary", exception.getMessage());
    }

    @Test
    void validate_lastNameIsNull_throwsRequiredFieldsException() {
        userModel.setLastName(null);
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'lastName' is necessary", exception.getMessage());
    }

    @Test
    void validate_lastNameIsEmpty_throwsRequiredFieldsException() {
        userModel.setLastName("");
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'lastName' is necessary", exception.getMessage());
    }

    @Test
    void validate_documentIdIsNull_throwsRequiredFieldsException() {
        userModel.setDocumentId(null);
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'documentId' is necessary", exception.getMessage());
    }

    @Test
    void validate_documentIdIsEmpty_throwsRequiredFieldsException() {
        userModel.setDocumentId("");
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'documentId' is necessary", exception.getMessage());
    }

    @Test
    void validate_phoneNumberIsNull_throwsRequiredFieldsException() {
        userModel.setPhoneNumber(null);
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'phoneNumber' is necessary", exception.getMessage());
    }

    @Test
    void validate_phoneNumberIsEmpty_throwsRequiredFieldsException() {
        userModel.setPhoneNumber("");
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'phoneNumber' is necessary", exception.getMessage());
    }

    @Test
    void validate_birthDateIsNull_throwsRequiredFieldsException() {
        userModel.setBirthDate(null);
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'birthDate' is necessary", exception.getMessage());
    }

    @Test
    void validate_emailIsNull_throwsRequiredFieldsException() {
        userModel.setEmail(null);
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'email' is necessary", exception.getMessage());
    }

    @Test
    void validate_emailIsEmpty_throwsRequiredFieldsException() {
        userModel.setEmail("");
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'email' is necessary", exception.getMessage());
    }

    @Test
    void validate_passwordIsNull_throwsRequiredFieldsException() {
        userModel.setPassword(null);
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'password' is necessary", exception.getMessage());
    }

    @Test
    void validate_passwordIsEmpty_throwsRequiredFieldsException() {
        userModel.setPassword("");
        RequiredFieldsException exception = assertThrows(RequiredFieldsException.class, () -> validator.validate(userModel));
        assertEquals("Field 'password' is necessary", exception.getMessage());
    }
}