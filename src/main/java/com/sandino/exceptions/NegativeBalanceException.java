package com.sandino.exceptions;

public class NegativeBalanceException extends Exception {
    public  NegativeBalanceException(String errorMessage) {
        super(errorMessage);
    }
}
