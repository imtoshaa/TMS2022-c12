package com.tms.second.exception;

public class WrongPasswordException extends Exception {

    public WrongPasswordException(String message, Exception exception) {
        super(message, exception);
    }
}
