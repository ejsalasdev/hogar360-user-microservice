package com.powerup.usermicroservice.domain.usecases;

import com.powerup.usermicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.ports.in.UserServicePort;
import com.powerup.usermicroservice.domain.ports.out.PasswordEncoderPort;
import com.powerup.usermicroservice.domain.ports.out.UserPersistencePort;
import com.powerup.usermicroservice.domain.utils.constants.DomainExceptionsConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import com.powerup.usermicroservice.domain.utils.validator.UserValidatorChain;

import java.util.Optional;

public class UserUseCase implements UserServicePort {
    
    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final UserValidatorChain userValidatorChain;

    public UserUseCase(UserPersistencePort userPersistencePort, PasswordEncoderPort passwordEncoderPort, UserValidatorChain userValidatorChain) {
        this.userPersistencePort = userPersistencePort;
        this.passwordEncoderPort = passwordEncoderPort;
        this.userValidatorChain = userValidatorChain;
    }

    @Override
    public void save(UserModel userModel) {
        userValidatorChain.validate(userModel);
        
        Optional<UserModel> user = userPersistencePort.getUserByDocumentId(userModel.getDocumentId());
        if (user.isPresent()) {
            throw new ElementAlreadyExistsException(String.format(DomainExceptionsConstants.USER_ALREADY_EXIST_MESSAGE, userModel.getDocumentId()));
        }
        
        String encodedPassword = passwordEncoderPort.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        userModel.setRole(UserConstants.SELLER_ROLE);
        
        userPersistencePort.save(userModel);
    }
}
