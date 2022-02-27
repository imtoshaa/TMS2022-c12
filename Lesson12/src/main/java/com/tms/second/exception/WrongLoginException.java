package com.tms.second.exception;

public class WrongLoginException extends Exception {

    public WrongLoginException(String message) {
        super(message);
    }
}
