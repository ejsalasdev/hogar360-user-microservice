package com.powerup.usermicroservice.domain.exceptions;

public class InvalidElementLengthException extends IllegalArgumentException{

    public InvalidElementLengthException(String s) {
        super(s);
    }
}
