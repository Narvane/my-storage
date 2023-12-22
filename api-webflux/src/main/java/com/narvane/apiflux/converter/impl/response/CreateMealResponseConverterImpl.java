package com.narvane.apiflux.converter.impl.response;

import com.narvane.apiflux.converter.ResponseConverter;
import com.narvane.apiflux.dto.CreateMealDTO;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateMealResponseConverterImpl extends AbstractResponseConverterImpl<Meal, CreateMealDTO.Response> implements ResponseConverter<Meal, CreateMealDTO.Response> {

    @Override
    protected CreateMealDTO.Response toResponse(Meal model) {
        // Pause webflux
        /*return CreateMealDTO.Response.builder()
                .name(model.getName())
                .protein(model.getProtein())
                .carbs(model.getCarbs())
                .fat(model.getFat())
                .foods(mapFood(model.getFoods()))
                .build();*/
        return null;
    }

    private List<CreateMealDTO.Response.Food> mapFood(List<Food> foods) {
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
