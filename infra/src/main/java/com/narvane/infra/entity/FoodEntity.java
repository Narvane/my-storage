package com.narvane.infra.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.util.UUID;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class FoodEntity implements AbstractEntity<UUID> {

    @Id
    private UUID id;

    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fat;

    @Column("meal_id")
    private UUID mealId;

    public FoodEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean isNew() {
        return true;
    }

}
