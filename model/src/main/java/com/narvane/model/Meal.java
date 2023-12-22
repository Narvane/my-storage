package com.narvane.model;

import java.util.*;
import java.util.stream.Collectors;

public class Meal extends GenericModel implements Eatable, Model {

    private String name;
    private final Set<Food> foods;

    public Meal(UUID uuid) {
        super(false);
        this.uuid = uuid;
        this.foods = new HashSet<>();
    }

    public Meal(String name) {
        super(true);
        this.name = name;
        this.foods = new HashSet<>();
    }

    public Meal(UUID uuid, String name) {
        super(false);
        this.uuid = uuid;
        this.name = name;
        this.foods = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addFood(Food food) {
        if (food != null) {
            foods.add(food);
        }
    }

    public void addFoods(Set<Food> foods) {
        if (foods != null && !foods.isEmpty()) {
            foods.forEach(this::addFood);
        }
    }

    public void updateFoods(Set<Food> foods) {
        this.addFoods(foods);
    }

    public void addFoods(Food... foods) {
        if (foods != null) {
            this.addFoods(Arrays.stream(foods).collect(Collectors.toSet()));
        }
    }

    public void removeFood(Food food) {
        foods.remove(food);
    }

    public Set<Food> getFoods() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Objects.equals(uuid, meal.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foods);
    }
}
