package com.narvane.apimvc.controller;

import com.narvane.apimvc.converter.RequestConverter;
import com.narvane.apimvc.converter.ResponseConverter;
import com.narvane.apimvc.dto.CreateMealDTO;
import com.narvane.apimvc.dto.UpdateMealDTO;
import com.narvane.model.Meal;
import com.narvane.service.meal.MealService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
@Validated
public class MealController extends AbstractController<Meal> {

    private MealService mealService;
    private RequestConverter<Meal, CreateMealDTO.Request> createMealRequestConverter;
    private ResponseConverter<Meal, CreateMealDTO.Response> createMealResponseConverter;

    private RequestConverter<Meal, UpdateMealDTO.Request> updateMealRequestConverter;
    private ResponseConverter<Meal, UpdateMealDTO.Response> updateMealResponseConverter;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMealDTO.Response create(@RequestBody @Valid CreateMealDTO.Request request) {
        return createMealResponseConverter.toResponse(
                mealService.create(createMealRequestConverter.toModel(request))
        );
    }

    /*@PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UpdateMealDTO.Response update(@RequestBody UpdateMealDTO.Request request) {
        return updateMealResponseConverter.toResponse(
                mealService.create(updateMealRequestConverter.toModel(request))
        );
    }*/

}
