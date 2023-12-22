package com.narvane.inframvc.converter.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MealEntityConverterImpl extends AbstractConverterImpl<Meal, MealEntity> implements GenericConverter<Meal, MealEntity> {

    protected final GenericConverter<Food, FoodEntity> foodEntityConverter;

    @Autowired
    public MealEntityConverterImpl(GenericConverter<Food, FoodEntity> foodEntityConverter) {
        this.foodEntityConverter = foodEntityConverter;
    }

    @Override
    public MealEntity toEntity(Meal meal) {
        var mealEntity = new MealEntity(meal.getUuid(), meal.getName());
        mealEntity.setNew(meal.isNew());
        mealEntity.setFoods(foodEntityConverter.toEntities(meal.getFoods()));

        return mealEntity;
    }

    @Override
    public Meal toModel(MealEntity mealEntity) {
        var meal = new Meal(mealEntity.getId(), mealEntity.getName());

        mealEntity.getFoods()
                .forEach(foodEntity -> meal.addFood(foodEntityConverter.toModel(foodEntity)));

        return meal;
    }

}
