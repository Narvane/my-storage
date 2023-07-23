package com.narvane.model;

import java.util.Objects;
import java.util.UUID;

public class Food implements Eatable, Model {

    private final UUID uuid;
    private final String name;

    private Integer protein;
    private Integer carbs;
    private Integer fat;

    public Food(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    @Override
    public Integer getCarbs() {
        return carbs;
    }

    public void setCarbs(Integer carbs) {
        this.carbs = carbs;
    }

    @Override
    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Objects.equals(uuid, food.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

}
