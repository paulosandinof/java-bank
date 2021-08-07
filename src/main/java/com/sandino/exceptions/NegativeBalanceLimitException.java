package com.sandino.exceptions;

public class NegativeBalanceLimitException extends Exception {
    public NegativeBalanceLimitException(String errorMessage) {
        super(errorMessage);
    }
}
