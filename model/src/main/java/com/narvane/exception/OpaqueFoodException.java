package com.narvane.exception;

public class OpaqueFoodException extends ValidationServiceException {

    public OpaqueFoodException() {
        super("food.must.contain.a.name");
    }

}
