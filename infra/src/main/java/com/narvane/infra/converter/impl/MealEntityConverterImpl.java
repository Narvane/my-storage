package com.narvane.infra.converter.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.MealEntity;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

@Component
public class MealEntityConverterImpl extends AbstractConverterImpl<Meal, MealEntity> implements GenericConverter<Meal, MealEntity> {

    @Override
    protected MealEntity toEntity(Meal meal) {
        return new MealEntity(meal.getUuid(), meal.getName());
    }

    @Override
    protected Meal toModel(MealEntity mealEntity) {
        return new Meal(mealEntity.getId(), mealEntity.getName());
    }

}
