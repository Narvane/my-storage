package com.narvane.inframvc.converter.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodEntityConverterImpl extends AbstractConverterImpl<Food, FoodEntity> implements GenericConverter<Food, FoodEntity> {

    @Override
    public FoodEntity toEntity(Food food) {
        var foodEntity = new FoodEntity(food.getUuid(), food.getName());
        foodEntity.setProtein(food.getProtein());
        foodEntity.setCarbs(food.getCarbs());
        foodEntity.setFat(food.getFat());
        return foodEntity;
    }

    @Override
    public Food toModel(FoodEntity foodEntity) {
        var food = new Food(foodEntity.getId(), foodEntity.getName());

        food.setProtein(foodEntity.getProtein());
        food.setCarbs(foodEntity.getCarbs());
        food.setFat(foodEntity.getFat());
        return food;
    }

}
