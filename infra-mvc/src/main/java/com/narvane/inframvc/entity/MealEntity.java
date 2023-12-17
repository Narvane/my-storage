package com.narvane.inframvc.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@Table(name = "MEAL")
public class MealEntity implements AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "MEAL_FOODS",
            joinColumns = @JoinColumn(name = "meal_id"),
            inverseJoinColumns = @JoinColumn(name = "food_id")
    )
    @ToString.Exclude
    private List<FoodEntity> foods;

    public MealEntity() {
        this.foods = new ArrayList<>();
    }

    public MealEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public void addFood(FoodEntity foodEntity) {
        foods.add(foodEntity);
    }

    public void removeFood(FoodEntity foodEntity) {
        foods.remove(foodEntity);
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