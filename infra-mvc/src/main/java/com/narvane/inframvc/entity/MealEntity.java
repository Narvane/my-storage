package com.narvane.inframvc.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "MEAL")
public class MealEntity extends AbstractEntityImpl implements AbstractEntity<UUID> {

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MEAL_FOODS",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    @ToString.Exclude
    private Set<FoodEntity> foods;

    public MealEntity() {
        super(true);
        this.foods = new HashSet<>();
    }

    public MealEntity(UUID id, String name) {
        super(false);
        this.id = id;
        this.name = name;
        this.foods = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MealEntity that = (MealEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}