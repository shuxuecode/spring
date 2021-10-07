package com.zsx.exception;

public class NoEmailException extends RuntimeException {
    public NoEmailException() {
        super();
    }

    public NoEmailException(Throwable cause) {
        super(cause);
    }

    public NoEmailException(String message) {
        super(message);
    }

    public NoEmailException(String message, Throwable cause) {
        super(message, cause);
    }

}
