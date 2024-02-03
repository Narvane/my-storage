package com.narvane.apimvc.controller;

import com.narvane.apimvc.datadispatcher.MealDataDispatcher;
import com.narvane.apimvc.dto.CreateMealDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/meal")
@RequiredArgsConstructor
@Validated
public class MealController {

    private final MealDataDispatcher dataDispatcher;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateMealDTO.Response create(@RequestBody @Valid CreateMealDTO.Request request) {
        return dataDispatcher.newMeal(request);
    }

    // TODO Later infra
    /*@PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public UpdateMealDTO.Response update(@RequestBody UpdateMealDTO.Request request) {
        return dataDispatcher.existentMeal(request);
    }*/

}
