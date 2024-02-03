package com.narvane.model;

import com.narvane.model.interfaces.Eatable;
import com.narvane.model.interfaces.IdentityModel;

import java.util.Objects;
import java.util.UUID;

public class Food extends AbstractIdentityModel implements Eatable, IdentityModel {

    private String name;

    private Integer protein;
    private Integer carbs;
    private Integer fat;

    public Food(UUID uuid) {
        super(false);
        this.uuid = uuid;
    }

    public Food(String name) {
        super(true);
        this.name = name;
    }

    public Food(UUID uuid, String name) {
        super(false);
        this.uuid = uuid;
        this.name = name;
    }

    public Food(UUID uuid, String name, Integer protein, Integer carbs, Integer fat) {
        super(false);
        this.uuid = uuid;
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

    public String getName() {
        return name;
    }

    public void update(Food update) {
        this.name = update.getName();
        this.protein = update.getProtein();
        this.carbs = update.getCarbs();
        this.fat = update.getFat();
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

    public boolean isEmptyNamed() {
        return name == null || name.equals("");
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
