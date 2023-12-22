package com.narvane.model;

import java.util.Map;

record Shelves<F extends Food>(Map<Food, Integer> foods) {

    void increaseAmount(F foodInput, Integer addedAmount) {
        foods.computeIfPresent(foodInput, (food, amount) -> amount + addedAmount);
    }

    void decreaseAmount(F foodOutput, Integer removedAmount) {
        foods.computeIfPresent(foodOutput, (food, amount) -> amount - removedAmount);
    }

}
