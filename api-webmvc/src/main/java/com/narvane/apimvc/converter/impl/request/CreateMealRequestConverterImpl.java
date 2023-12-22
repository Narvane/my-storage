package com.narvane.apimvc.converter.impl.request;

import com.narvane.apimvc.converter.RequestConverter;
import com.narvane.apimvc.dto.CreateMealDTO;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class CreateMealRequestConverterImpl extends AbstractRequestConverterImpl<Meal, CreateMealDTO.Request> implements RequestConverter<Meal, CreateMealDTO.Request> {

    @Override
    public Meal toModel(CreateMealDTO.Request request) {
        var meal = new Meal(request.getName());
        //Converter de food!
        request.getFoods().forEach(foodRequest -> {
            var food = Optional.ofNullable(foodRequest.getUuid())
                    .map(uuid -> new Food(UUID.fromString(uuid), foodRequest.getName()))
                    .orElse(new Food(foodRequest.getName()));
            food.setProtein(foodRequest.getProtein());
            food.setCarbs(foodRequest.getCarbs());
            food.setFat(foodRequest.getFat());
            meal.addFood(food);
        });
        return meal;
    }

}
