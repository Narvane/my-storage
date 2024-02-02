package com.narvane.model;

import java.util.*;

public class Meal extends AbstractIdentityModel implements Eatable, IdentityModel {

    private String name;

    private final Portions portions;

    public Meal(UUID uuid, Portions portions) {
        super(false);
        this.uuid = uuid;
        this.portions = new Portions();
    }

    public Meal(String name) {
        super(true);
        this.name = name;
        this.portions = new Portions();
    }

    public Meal(UUID uuid, String name) {
        super(false);
        this.uuid = uuid;
        this.name = name;
        this.portions = new Portions();
    }

    public String getName() {
        return name;
    }

    public void addPortion(Food food, Integer amount) {
        if (food != null) {
            if (!portions.of(food).exist()) {
                addPortion(food);
            }
            portions.of(food).update(amount);
        }
    }

    public void addPortion(Food food) {
        if (food != null) {
            portions.newOf(food);
        }
    }

    public void update(Meal updated) {
        this.name = updated.getName();
    }

    public void removeFood(Food food) {
        portions.of(food).remove();
    }

    public Portions getPortions() {
        return portions;
    }

    public boolean haveAnyFood() {
        return !portions.isEmpty();
    }

    @Override
    public Integer getProtein() {
        return portions.getTotalProtein();
    }

    @Override
    public Integer getCarbs() {
        return portions.getTotalCarbs();
    }

    @Override
    public Integer getFat() {
        return portions.getTotalFat();
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
        return Objects.hash(name, portions);
    }

}
