package com.narvane.apimvc.converter.impl.response;

import com.narvane.apimvc.converter.ResponseConverter;
import com.narvane.apimvc.dto.CreateMealDTO;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class CreateMealResponseConverterImpl extends AbstractResponseConverterImpl<Meal, CreateMealDTO.Response> implements ResponseConverter<Meal, CreateMealDTO.Response> {

    @Override
    public CreateMealDTO.Response toResponse(Meal model) {
        return CreateMealDTO.Response.builder()
                .name(model.getName())
                .protein(model.getProtein())
                .carbs(model.getCarbs())
                .fat(model.getFat())
                .foods(mapFood(model.getFoods()))
                .build();
    }

    private List<CreateMealDTO.Response.Food> mapFood(Set<Food> foods) {
        return foods.stream().map(food -> {
            var foodResponse = new CreateMealDTO.Response.Food();
            foodResponse.setName(food.getName());
            foodResponse.setProtein(food.getProtein());
            foodResponse.setCarbs(food.getCarbs());
            foodResponse.setFat(food.getFat());

            return foodResponse;
        }).toList();
    }

}
