package com.powerup.usermicroservice.domain.utils.constants;

import com.powerup.usermicroservice.domain.model.RoleModel;

public final class UserConstants {
    
    public static final RoleModel SELLER_ROLE = new RoleModel(1L, "seller", "User with seller role");
    public static final Integer DOCUMENT_ID_MAX_LENGTH = 10;
    public static final Integer DOCUMENT_ID_MIN_LENGTH = 8;
    public static final String ONLY_NUMERIC_REGEX = "^\\d+$";
    public static final String ONLY_STRING_REGEX = "^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$";
    public static final String EMAIL_FORMAT_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final Integer PHONE_NUMBER_MAX_LENGTH = 13;
    public static final Integer PHONE_NUMBER_MIN_LENGTH = 10;
    public static final String PHONE_NUMBER_FORMAT_REGEX = "^\\+?\\d+$";
    public static final String TIME_ZONE = "America/Bogota";
    public static final Integer ADULT_AGE = 18;
    
    private UserConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
