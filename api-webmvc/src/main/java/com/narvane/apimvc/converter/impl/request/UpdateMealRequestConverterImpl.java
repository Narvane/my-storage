package com.narvane.apimvc.converter.impl.request;

import com.narvane.apimvc.converter.RequestConverter;
import com.narvane.apimvc.dto.UpdateMealDTO;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateMealRequestConverterImpl extends AbstractRequestConverterImpl<Meal, UpdateMealDTO.Request> implements RequestConverter<Meal, UpdateMealDTO.Request> {

    @Override
    public Meal toModel(UpdateMealDTO.Request request) {
        var meal = new Meal(UUID.fromString(request.getId()), request.getName());
        // TODO Later infra
        /*//Converter de food!
        request.getFoods().forEach(foodRequest -> {
            var food = Optional.ofNullable(foodRequest.getId())
                    .map(uuid -> new Food(UUID.fromString(uuid), foodRequest.getName()))
                    .orElse(new Food(foodRequest.getName()));
            food.setProtein(foodRequest.getProtein());
            food.setCarbs(foodRequest.getCarbs());
            food.setFat(foodRequest.getFat());
            meal.addPortion(food);
        });*/
        return meal;
    }

}
