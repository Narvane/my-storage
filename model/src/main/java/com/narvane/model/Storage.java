package com.narvane.model;

import java.util.HashMap;
import java.util.Map;

public class Storage {
    private final Shelves<Food> foodShelves;
    private final History<MovementType> history;

    public Storage(HashMap<Food, Integer> foodShelves) {
        this.foodShelves = new Shelves<>(foodShelves);
        this.history = new History<>(new HashMap<>());
    }

    public void input(Movement movement) {
        foodShelves.increaseAmount(movement.getFood(), movement.getAmount());
        history.registerMovement(MovementType.INPUT, movement);
    }

    public void output(Movement movement) {
        foodShelves.decreaseAmount(movement.getFood(), movement.getAmount());
        history.registerMovement(MovementType.OUTPUT, movement);
    }

    public Map<Food, Integer> getFoodShelves() {
        return foodShelves.foods();
    }

    public Map<MovementType, Movement> getHistory() {
        return history.movements();
    }

}
