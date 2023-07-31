package com.narvane.api.controller;

import com.narvane.api.converter.RequestConverter;
import com.narvane.api.converter.ResponseConverter;
import com.narvane.api.dto.CreateMealDTO;
import com.narvane.model.Meal;
import com.narvane.model.infra.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
public class MealController {

    private MealService mealService;
    private RequestConverter<Meal, CreateMealDTO.Request> createMealRequestconverter;
    private ResponseConverter<Meal, CreateMealDTO.Response> createMealResponseconverter;

    @PostMapping("/create")
    public Mono<CreateMealDTO.Response> create(@RequestBody CreateMealDTO.Request request) {
        var createdMeal = mealService.create(createMealRequestconverter.toEntity(request));
        return createMealResponseconverter.toVO(createdMeal);
    }

}
