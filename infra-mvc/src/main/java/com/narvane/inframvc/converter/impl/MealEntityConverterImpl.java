package com.narvane.inframvc.converter.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

@Component
public class MealEntityConverterImpl extends AbstractConverterImpl<Meal, MealEntity> implements GenericConverter<Meal, MealEntity> {

    @Override
    public MealEntity toEntity(Meal meal) {
        var mealEntity = new MealEntity(meal.getUuid(), meal.getName());

        meal.getFoods().forEach(food -> {
            var foodEntity = new FoodEntity(food.getUuid(), food.getName());
            foodEntity.setProtein(food.getProtein());
            foodEntity.setCarbs(food.getCarbs());
            foodEntity.setFat(food.getFat());
            mealEntity.addFood(foodEntity);
        });

        return mealEntity;
    }

    @Override
    public Meal toModel(MealEntity mealEntity) {
        var meal = new Meal(mealEntity.getId(), mealEntity.getName());

        mealEntity.getFoods().forEach(foodEntity -> {
            var food = new Food(foodEntity.getId(), foodEntity.getName());

            food.setProtein(foodEntity.getProtein());
            food.setCarbs(foodEntity.getCarbs());
            food.setFat(foodEntity.getFat());
            meal.addFood(food);
        });

        return meal;
    }

}
