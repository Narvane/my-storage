package com.narvane.app.converter.impl.request;

import com.narvane.app.converter.RequestConverter;
import com.narvane.app.dto.CreateMealDTO;
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

        request.getPortions().forEach(portionDto -> {
            var foodDto = portionDto.getFood();

            var food = Optional.ofNullable(foodDto.getId())
                    .map(uuid -> new Food(UUID.fromString(uuid), foodDto.getName()))
                    .orElse(new Food(foodDto.getName()));

            food.setProtein(foodDto.getProtein());
            food.setCarbs(foodDto.getCarbs());
            food.setFat(foodDto.getFat());

            meal.addPortion(
                    food,
                    portionDto.getAmount()
            );
        });
        return meal;
    }

}
