package com.narvane.exception;

public class MealWithoutFoodsException extends ValidationServiceException {

    public MealWithoutFoodsException() {
        super("meal.must.contain.at.least.one.food");
    }

}
