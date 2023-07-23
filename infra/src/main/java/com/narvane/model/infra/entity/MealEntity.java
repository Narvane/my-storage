package com.narvane.model.infra.entity;

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
@RequiredArgsConstructor
public class MealEntity implements AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "meal_id")
    @ToString.Exclude
    private final List<FoodEntity> foods;

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
