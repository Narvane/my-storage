package com.narvane.apimvc.converter.impl.response;

import com.narvane.apimvc.converter.ResponseConverter;
import com.narvane.apimvc.dto.CreateMealDTO;
import com.narvane.model.Portions;
import com.narvane.model.Meal;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateMealResponseConverterImpl extends AbstractResponseConverterImpl<Meal, CreateMealDTO.Response> implements ResponseConverter<Meal, CreateMealDTO.Response> {

    @Override
    public CreateMealDTO.Response toResponse(Meal model) {
        return CreateMealDTO.Response.builder()
                .id(model.getUuid().toString())
                .name(model.getName())
                .protein(model.getProtein())
                .carbs(model.getCarbs())
                .fat(model.getFat())
                .portions(mapPortions(model.getPortions()))
                .build();
    }

    @Override
    public Class<?> converterOf() {
        return CreateMealDTO.Response.class;
    }

    private List<CreateMealDTO.Response.Portion> mapPortions(Portions portions) {
        return portions.stream().map(portion -> {
            var food = portion.getFood();

            var foodDto = new CreateMealDTO.Response.Food();
            foodDto.setId(food.getUuid().toString());
            foodDto.setName(food.getName());
            foodDto.setProtein(food.getProtein());
            foodDto.setCarbs(food.getCarbs());
            foodDto.setFat(food.getFat());

            var portionDto = new CreateMealDTO.Response.Portion();
            portionDto.setAmount(portion.getAmount());
            portionDto.setFood(foodDto);

            return portionDto;
        }).toList();
    }

}
