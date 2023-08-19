package com.narvane.model;

import java.util.*;

public class Meal implements Eatable, Model {

    private UUID uuid;
    private final String name;
    private final List<Food> foods;

    public Meal(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
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
        return foods.stream()
                .map(Food::getProtein)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .boxed()
                .reduce(Integer::sum)
                .orElse(null);
    }

    @Override
    public Integer getCarbs() {
        return foods.stream()
                .map(Food::getCarbs)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .boxed()
                .reduce(Integer::sum)
                .orElse(null);
    }

    @Override
    public Integer getFat() {
        return foods.stream()
                .map(Food::getFat)
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .boxed()
                .reduce(Integer::sum)
                .orElse(null);
    }

}
