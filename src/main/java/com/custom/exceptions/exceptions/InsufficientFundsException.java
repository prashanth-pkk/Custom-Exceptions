package com.custom.exceptions.exceptions;

public class InsufficientFundsException extends Exception {
    public InsufficientFundsException() {
        super();
    }

    public InsufficientFundsException(String str) {
        super(str);
    }

    public InsufficientFundsException(String str, Throwable throwable) {
        super(str, throwable);
    }

    public InsufficientFundsException(Throwable throwable) {
        super(throwable);
    }

}





