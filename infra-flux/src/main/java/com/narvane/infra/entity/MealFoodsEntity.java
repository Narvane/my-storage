package com.narvane.infra.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Table("MEAL_FOODS")
public class MealFoodsEntity extends AbstractEntityImpl implements AbstractEntity<UUID> {

    @Id
    private UUID id;

    @Column("meal_id")
    private UUID mealId;

    @Column("food_id")
    private UUID foodId;

    public MealFoodsEntity(UUID mealId, UUID foodId) {
        this.setNew();
        this.mealId = mealId;
        this.foodId = foodId;
    }

}
