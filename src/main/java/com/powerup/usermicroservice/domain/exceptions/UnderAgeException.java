package com.powerup.usermicroservice.domain.exceptions;

public class UnderAgeException extends IllegalArgumentException{

    public UnderAgeException(String s) {
        super(s);
    }
}
