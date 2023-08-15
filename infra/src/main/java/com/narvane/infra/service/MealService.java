package com.narvane.infra.service;

import com.narvane.model.Meal;
import reactor.core.publisher.Mono;

public interface MealService {

    Mono<Meal> create(Mono<Meal> monoMeal);

}
