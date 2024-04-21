package com.narvane.app.converter.impl.response;

import com.narvane.app.converter.ResponseConverter;
import com.narvane.app.dto.UpdateMealDTO;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class UpdateMealResponseConverterImpl extends AbstractResponseConverterImpl<Meal, UpdateMealDTO.Response> implements ResponseConverter<Meal, UpdateMealDTO.Response> {

    @Override
    public UpdateMealDTO.Response toResponse(Meal model) {
        return UpdateMealDTO.Response.builder()
                .id(model.getId().toString())
                .name(model.getName())
                .protein(model.getProtein())
                .carbs(model.getCarbs())
                .fat(model.getFat())
                // TODO Later infra
                /*.foods(mapFood(model.getPortions()))*/
                .build();
    }

    @Override
    public Class<?> converterOf() {
        return UpdateMealDTO.Response.class;
    }

    private List<UpdateMealDTO.Response.Food> mapFood(Set<Food> foods) {
        return foods.stream().map(food -> {
            var foodResponse = new UpdateMealDTO.Response.Food();
            foodResponse.setId(food.getId().toString());
            foodResponse.setName(food.getName());
            foodResponse.setProtein(food.getProtein());
            foodResponse.setCarbs(food.getCarbs());
            foodResponse.setFat(food.getFat());

            return foodResponse;
        }).toList();
    }

}
