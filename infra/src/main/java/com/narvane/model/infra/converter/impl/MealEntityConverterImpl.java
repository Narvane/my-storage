package com.narvane.model.infra.converter.impl;

import com.narvane.model.Food;
import com.narvane.model.Meal;
import com.narvane.model.infra.converter.GenericConverter;
import com.narvane.model.infra.entity.FoodEntity;
import com.narvane.model.infra.entity.MealEntity;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class MealEntityConverterImpl implements GenericConverter<Meal, MealEntity> {

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
    public Mono<Meal> toModel(Mono<MealEntity> mealEntityMono) {
        return mealEntityMono.map(mealEntity -> {
            var meal = new Meal(mealEntity.getId(), mealEntity.getName());

            mealEntity.getFoods().forEach(foodEntity -> {
                var food = new Food(foodEntity.getId(), foodEntity.getName());

                food.setProtein(foodEntity.getProtein());
                food.setCarbs(foodEntity.getCarbs());
                food.setFat(foodEntity.getFat());
                meal.addFood(food);
            });

            return meal;
        });
    }

}
