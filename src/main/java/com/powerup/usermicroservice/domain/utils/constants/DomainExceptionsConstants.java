package com.powerup.usermicroservice.domain.utils.constants;

public final class DomainExceptionsConstants {
    
    public static final String USER_ALREADY_EXIST_MESSAGE = "User with documentId '%s' already exists";
    public static final String REQUIRED_FIELD_MESSAGE = "Field %s is necesary";
    public static final String STRING_INPUT_FORMAT_ERROR_MESSAGE = "Field %s '%s' contains invalid characters. Only letters and space are allowed.";
    public static final String DOCUMENT_ID_NOT_NUMERIC_MESSAGE = "Document ID only numeric allowed";
    public static final String DOCUMENT_ID_INVALID_LENGTH_MESSAGE = "Document ID lenght must be between 8 and 10 dígits.";
    public static final String PHONE_NUMBER_INVALID_FORMAT_MESSAGE = "El formato del número de celular no es válido (máximo 13 caracteres, puede incluir +).";
    public static final String PHONE_NUMBER_INVALID_LENGTH_MESSAGE = "El phone number debe estar entre 10 y 13 dígitos.";
    public static final String USER_UNDER_AGE_VALID_MESSAGE = "El usuario debe ser mayor de edad.";
    public static final String EMAIL_INVALID_FORMAT_MESSAGE = "El formato del correo electrónico no es válido.";
    
    private DomainExceptionsConstants() {
        throw new IllegalStateException("Utility Class");
    }
}
