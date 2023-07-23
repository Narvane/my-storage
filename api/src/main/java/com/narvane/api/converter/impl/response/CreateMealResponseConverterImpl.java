package com.narvane.api.converter.impl.response;

import com.narvane.api.converter.ResponseConverter;
import com.narvane.api.vo.CreateMealResponse;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class CreateMealResponseConverterImpl implements ResponseConverter<Meal, CreateMealResponse> {
    @Override
    public Mono<CreateMealResponse> toVO(Mono<Meal> monoModel) {
        return monoModel.map(model ->
                CreateMealResponse.builder()
                    .name(model.getName())
                    .protein(model.getProtein())
                    .carbs(model.getCarbs())
                    .fat(model.getFat())
                    .foods(mapFood(model.getFoods()))
                .build()
        );
    }

    private List<CreateMealResponse.Food> mapFood(List<Food> foods) {
        return foods.stream().map(food -> {
            var foodResponse = new CreateMealResponse.Food();
            foodResponse.setName(food.getName());
            foodResponse.setProtein(food.getProtein());
            foodResponse.setCarbs(food.getCarbs());
            foodResponse.setFat(food.getFat());

            return foodResponse;
        }).toList();
    }

}
