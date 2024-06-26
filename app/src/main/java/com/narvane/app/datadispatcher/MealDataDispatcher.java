package com.narvane.app.datadispatcher;

import com.narvane.app.converter.RequestConverter;
import com.narvane.app.converter.ResponseConverter;
import com.narvane.app.dto.CreateMealDTO;
import com.narvane.app.dto.UpdateMealDTO;
import com.narvane.model.Meal;
import com.narvane.service.meal.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MealDataDispatcher {

    private final MealService mealService;

    private final RequestConverter<Meal, CreateMealDTO.Request> createMealRequestConverter;
    private final ResponseConverter<Meal, CreateMealDTO.Response> createMealResponseConverter;

    private final RequestConverter<Meal, UpdateMealDTO.Request> updateMealRequestConverter;
    private final ResponseConverter<Meal, UpdateMealDTO.Response> updateMealResponseConverter;

    public CreateMealDTO.Response newMeal(CreateMealDTO.Request request) {
        return createMealResponseConverter.toResponse(
                mealService.create(createMealRequestConverter.toModel(request))
        );
    }

    public UpdateMealDTO.Response existentMeal(UpdateMealDTO.Request request) {
        return updateMealResponseConverter.toResponse(
                mealService.update(updateMealRequestConverter.toModel(request))
        );
    }

}
