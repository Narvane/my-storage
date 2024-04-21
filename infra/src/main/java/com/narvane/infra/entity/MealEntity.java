package com.narvane.infra.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "MEAL")
public class MealEntity extends AbstractEntityImpl implements AbstractEntity<UUID> {

    private String name;

    @ElementCollection
    @CollectionTable(name = "MEAL_PORTIONS",
            joinColumns = {@JoinColumn(name = "meal_id")})
    @MapKeyJoinColumn(name = "food_id")
    @Column(name = "amount", nullable = false)
    private Map<FoodEntity, Integer> portions;

    public MealEntity() {
        super(true);
        this.portions = new HashMap<>();
    }

    public MealEntity(UUID id, String name) {
        super(false);
        this.id = id;
        this.name = name;
        this.portions = new HashMap<>();
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