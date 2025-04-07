package com.powerup.usermicroservice.domain.exceptions;

public class RequiredFieldsException extends IllegalArgumentException{

    public RequiredFieldsException(String s) {
        super(s);
    }
}
