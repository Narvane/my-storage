package com.narvane.infra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "FOOD")
public class FoodEntity extends AbstractEntityImpl implements AbstractEntity<UUID> {

    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fat;

    public FoodEntity(UUID id, String name) {
        super(false);
        this.id = id;
        this.name = name;
    }

    public FoodEntity() {
        super(true);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FoodEntity that = (FoodEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}