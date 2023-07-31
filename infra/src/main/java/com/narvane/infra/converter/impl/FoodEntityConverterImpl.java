package com.narvane.infra.converter.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.FoodEntity;
import com.narvane.model.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodEntityConverterImpl implements GenericConverter<Food, FoodEntity> {

    @Override
    public FoodEntity toEntity(Food food) {
        FoodEntity foodEntity = new FoodEntity();
        foodEntity.setName(food.getName());
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
