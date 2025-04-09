package com.powerup.usermicroservice.domain.usecases;

import com.powerup.usermicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.usermicroservice.domain.model.RoleModel;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.ports.out.PasswordEncoderPort;
import com.powerup.usermicroservice.domain.ports.out.UserPersistencePort;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.UserValidatorChain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class UserUseCaseTest {

    @Mock
    private UserPersistencePort userPersistencePort;

    @Mock
    private PasswordEncoderPort passwordEncoderPort;

    @Mock
    private UserValidatorChain userValidatorChain;

    @InjectMocks
    private UserUseCase userUseCase;

    private UserModel userModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RoleModel sellerRole = new RoleModel(1L, "vendedor", "Usuario con rol de vendedor");
        userModel = new UserModel(
                null,
                "Test",
                "User",
                "123456789",
                "+573001234567",
                LocalDate.of(1990, 1, 1),
                "test@example.com",
                "password123",
                sellerRole
        );
    }

    @Test
    void When_NewUserProvided_Expect_UserToBeSavedSuccessfully() {
        // Arrange
        when(userPersistencePort.getUserByDocumentId(userModel.getDocumentId())).thenReturn(Optional.empty());
        when(passwordEncoderPort.encode(userModel.getPassword())).thenReturn("encodedPassword");

        // Act
        userUseCase.save(userModel);

        // Assert
        verify(userValidatorChain, times(1)).validate(userModel);
        verify(userPersistencePort, times(1)).save(userModel);
        assertEquals("encodedPassword", userModel.getPassword());
        assertEquals(UserConstants.SELLER_ROLE, userModel.getRole());
    }

    @Test
    void When_ExistingUserProvided_Expect_ElementAlreadyExistsExceptionToBeThrown() {
        // Arrange
        when(userPersistencePort.getUserByDocumentId(userModel.getDocumentId())).thenReturn(Optional.of(userModel));

        // Act & Assert
        assertThrows(ElementAlreadyExistsException.class, () -> userUseCase.save(userModel));
        verify(userValidatorChain, times(1)).validate(userModel);
        verify(userPersistencePort, never()).save(any());
    }

    @Test
    void When_SaveUserCalled_Expect_UserValidatorChainIsInvoked() {
        // Arrange
        when(userPersistencePort.getUserByDocumentId(userModel.getDocumentId())).thenReturn(Optional.empty());
        when(passwordEncoderPort.encode(userModel.getPassword())).thenReturn("encodedPassword");

        // Act
        userUseCase.save(userModel);

        // Assert
        verify(userValidatorChain, times(1)).validate(userModel);
    }
}