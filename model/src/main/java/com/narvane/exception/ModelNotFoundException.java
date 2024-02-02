package com.narvane.exception;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException() {
        super("model.not.found");
    }

}
