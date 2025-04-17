package com.powerup.usermicroservice.domain.exceptions;

public class ElementNotFoundException extends IllegalArgumentException {

    public ElementNotFoundException(String s) {
        super(s);
    }
}
