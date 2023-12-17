package com.narvane.infra.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@ToString
@Table("MEAL_FOODS")
public class FoodEntity extends AbstractEntityImpl implements AbstractEntity<UUID> {

    @Id
    private UUID id;

    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fat;

    public FoodEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

}
