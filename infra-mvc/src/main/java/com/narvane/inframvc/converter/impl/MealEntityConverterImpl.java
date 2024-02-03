package com.narvane.inframvc.converter.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class MealEntityConverterImpl extends AbstractConverterImpl<Meal, MealEntity> implements GenericConverter<Meal, MealEntity> {

    protected final GenericConverter<Food, FoodEntity> foodEntityConverter;

    @Autowired
    public MealEntityConverterImpl(GenericConverter<Food, FoodEntity> foodEntityConverter) {
        this.foodEntityConverter = foodEntityConverter;
    }

    @Override
    public MealEntity toEntity(Meal meal) {
        var mealEntity = new MealEntity(meal.getId(), meal.getName());
        mealEntity.setNew(meal.isNew());

        var portionsEntity = new HashMap<FoodEntity, Integer>();
        meal.getPortions().stream().forEach(
                portion -> portionsEntity.put(
                        foodEntityConverter.toEntity(portion.getFood())
                        , portion.getAmount()
                )
        );

        mealEntity.setPortions(portionsEntity);

        return mealEntity;
    }

    @Override
    public Meal toModel(MealEntity mealEntity) {
        var meal = new Meal(mealEntity.getId(), mealEntity.getName());

        mealEntity.getPortions().forEach((foodEntity, amount) ->
                meal.addPortion(
                        foodEntityConverter.toModel(foodEntity),
                        amount
                )
        );
        return meal;
    }

}
