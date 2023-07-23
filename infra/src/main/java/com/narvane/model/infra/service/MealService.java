package com.narvane.model.infra.service;

import com.narvane.model.Meal;
import reactor.core.publisher.Mono;

public interface MealService {

    Mono<Meal> create(Meal meal);

}
