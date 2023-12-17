package com.narvane.apiflux.controller;

import com.narvane.apiflux.converter.RequestConverter;
import com.narvane.apiflux.converter.ResponseConverter;
import com.narvane.apiflux.dto.CreateMealDTO;
import com.narvane.infra.service.MealService;
import com.narvane.model.Meal;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
public class MealController {

    private MealService mealService;
    private RequestConverter<Meal, CreateMealDTO.Request> createMealRequestconverter;
    private ResponseConverter<Meal, CreateMealDTO.Response> createMealResponseconverter;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CreateMealDTO.Response> create(@RequestBody Mono<CreateMealDTO.Request> request) {
        var createdMeal = mealService.create(createMealRequestconverter.toModel(request));
        return createMealResponseconverter.toResponse(createdMeal);
    }

}
