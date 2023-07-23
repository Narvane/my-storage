package com.narvane.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Meal implements Eatable, Model {

    private UUID uuid;
    private final String name;
    private List<Food> foods;

    public Meal(String name) {
        this.name = name;
    }

    public Meal(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public List<Food> getFoods() {
        return foods;
    }

    @Override
    public Integer getProtein() {
        return foods.stream().mapToInt(Food::getProtein).sum();
    }

    @Override
    public Integer getCarbs() {
        return foods.stream().mapToInt(Food::getCarbs).sum();
    }

    @Override
    public Integer getFat() {
        return foods.stream().mapToInt(Food::getFat).sum();
    }

}
