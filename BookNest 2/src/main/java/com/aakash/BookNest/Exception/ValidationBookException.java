package com.aakash.BookNest.Exception;

public class ValidationBookException extends Exception {

    public ValidationBookException(String message) {
        super(message);
    }

    public ValidationBookException(String message, Throwable cause) {
        super(message, cause);
    }
}
