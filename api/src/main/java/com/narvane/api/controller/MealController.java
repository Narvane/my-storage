package com.narvane.api.controller;

import com.narvane.api.converter.RequestConverter;
import com.narvane.api.converter.ResponseConverter;
import com.narvane.api.dto.CreateMealDTO;
import com.narvane.model.Meal;
import com.narvane.infra.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.publisher.MonoSink;

@RestController
@RequestMapping("/api/meal")
@AllArgsConstructor
public class MealController {

    private MealService mealService;
    private RequestConverter<Meal, CreateMealDTO.Request> createMealRequestconverter;
    private ResponseConverter<Meal, CreateMealDTO.Response> createMealResponseconverter;

    @PostMapping("/create")
    public Mono<CreateMealDTO.Response> create(@RequestBody CreateMealDTO.Request request) {
        var createdMeal = mealService.create(createMealRequestconverter.toModel(request));
        return createMealResponseconverter.toVO(createdMeal);
    }

    @GetMapping("ping")
    public Mono<String> ping() {
        return Mono.create(MonoSink::success);
    }

}
