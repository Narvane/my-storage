package com.narvane.apimvc.controller;

import com.narvane.apimvc.converter.RequestConverter;
import com.narvane.apimvc.converter.ResponseConverter;
import com.narvane.apimvc.dto.CreateMealDTO;
import com.narvane.model.Meal;
import com.narvane.inframvc.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
public class MealController {

    private MealService mealService;
    private RequestConverter<Meal, CreateMealDTO.Request> requestConverter;
    private ResponseConverter<Meal, CreateMealDTO.Response> responseConverter;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMealDTO.Response create(@RequestBody CreateMealDTO.Request request) {
        return responseConverter.toResponse(
                mealService.create(requestConverter.toModel(request))
        );
    }

}
