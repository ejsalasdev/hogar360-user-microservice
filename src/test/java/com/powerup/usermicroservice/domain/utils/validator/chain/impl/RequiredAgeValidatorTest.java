package com.powerup.usermicroservice.domain.utils.validator.chain.impl;

import com.powerup.usermicroservice.domain.exceptions.UnderAgeException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;

class RequiredAgeValidatorTest {

    private RequiredAgeValidator validator;
    private UserModel userModel;
    private LocalDate today;

    @BeforeEach
    void setUp() {
        validator = new RequiredAgeValidator();
        userModel = new UserModel(null, "Test", "User", "123", "123", null, "test@test.com", "pass", null);
        ZoneId colombiaZoneId = ZoneId.of(UserConstants.TIME_ZONE);
        today = LocalDate.now(colombiaZoneId);
    }

    @Test
    void validate_birthDateIsNull_doesNotThrowException() {
        userModel.setBirthDate(null);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @Test
    void validate_userIsAdult_doesNotThrowException() {
        LocalDate adultBirthDate = today.minusYears(UserConstants.ADULT_AGE);
        userModel.setBirthDate(adultBirthDate);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @Test
    void validate_userIsOlderThanAdult_doesNotThrowException() {
        LocalDate olderBirthDate = today.minusYears(UserConstants.ADULT_AGE + 5);
        userModel.setBirthDate(olderBirthDate);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @Test
    void validate_userIsExactlyAdultAge_doesNotThrowException() {
        LocalDate exactAdultBirthDate = today.minusYears(UserConstants.ADULT_AGE);
        userModel.setBirthDate(exactAdultBirthDate);
        assertDoesNotThrow(() -> validator.validate(userModel));
    }

    @Test
    void validate_userIsUnderAge_throwsUnderAgeException() {
        LocalDate underAgeBirthDate = today.minusYears(UserConstants.ADULT_AGE - 1);
        userModel.setBirthDate(underAgeBirthDate);
        UnderAgeException exception = assertThrows(UnderAgeException.class, () -> validator.validate(userModel));
        assertEquals(String.format(DomainExceptionsConstants.USER_UNDER_AGE_VALID_MESSAGE), exception.getMessage());
    }

    @Test
    void validate_userIsJustUnderAge_throwsUnderAgeException() {
        LocalDate justUnderAgeBirthDate = today.minusYears(UserConstants.ADULT_AGE).plusDays(1);
        userModel.setBirthDate(justUnderAgeBirthDate);
        UnderAgeException exception = assertThrows(UnderAgeException.class, () -> validator.validate(userModel));
        assertEquals(String.format(DomainExceptionsConstants.USER_UNDER_AGE_VALID_MESSAGE), exception.getMessage());
    }
}