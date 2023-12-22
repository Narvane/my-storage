package com.narvane.model;


import java.time.LocalDateTime;

public class Movement {

    private Food food;

    private Integer amount;

    private LocalDateTime dateTime;


    public Food getFood() {
        return food;
    }

    public Integer getAmount() {
        return amount;
    }

}
