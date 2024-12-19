package com.wora.majesticcup.exceptions;

public class PasswordIncorrect extends RuntimeException {
    public PasswordIncorrect(String message) {
        super(message);
    }
}
