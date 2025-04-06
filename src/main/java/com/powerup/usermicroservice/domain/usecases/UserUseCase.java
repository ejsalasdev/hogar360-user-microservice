package com.powerup.usermicroservice.domain.usecases;

import com.powerup.usermicroservice.domain.exceptions.ElementAlreadyExistsException;
import com.powerup.usermicroservice.domain.model.UserModel;
import com.powerup.usermicroservice.domain.ports.in.UserServicePort;
import com.powerup.usermicroservice.domain.ports.out.UserPersistencePort;
import com.powerup.usermicroservice.domain.utils.constants.DomainConstants;
import com.powerup.usermicroservice.domain.utils.constants.UserConstants;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserUseCase implements UserServicePort {
    
    private final UserPersistencePort userPersistencePort;
    private final PasswordEncoder passwordEncoder;

    public UserUseCase(UserPersistencePort userPersistencePort, PasswordEncoder passwordEncoder) {
        this.userPersistencePort = userPersistencePort;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(UserModel userModel) {
        Optional<UserModel> user = userPersistencePort.getUserByDocumentId(userModel.getDocumentId());
        if (user.isPresent()) {
            throw new ElementAlreadyExistsException(String.format(DomainConstants.USER_ALREADY_EXIST_MESSAGE, userModel.getDocumentId()));
        }
        String encodedPassword = passwordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        userModel.setRole(UserConstants.SELLER_ROLE);
        userPersistencePort.save(userModel);
    }
}
