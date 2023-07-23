package com.narvane.api.converter.impl.request;

import com.narvane.api.converter.RequestConverter;
import com.narvane.api.vo.CreateMealRequest;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateMealRequestConverterImpl implements RequestConverter<Meal, CreateMealRequest> {

    @Override
    public Meal toEntity(CreateMealRequest request) {
        var meal = new Meal(UUID.fromString(request.getUuid()), request.getName());

        request.getFoods().forEach(foodRequest -> {
            var food = new Food(UUID.fromString(foodRequest.getUuid()), foodRequest.getName());
            food.setProtein(foodRequest.getProtein());
            food.setCarbs(foodRequest.getCarbs());
            food.setFat(foodRequest.getFat());
            meal.addFood(food);
        });
        return meal;
    }

}
