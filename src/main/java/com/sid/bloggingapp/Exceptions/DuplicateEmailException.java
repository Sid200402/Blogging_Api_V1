package com.sid.bloggingapp.Exceptions;

public class DuplicateEmailException extends RuntimeException {

    public DuplicateEmailException(String message) {
        super(message);
    }

}
