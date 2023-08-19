package com.narvane.inframvc.service;

import com.narvane.inframvc.entity.MealEntity;
import com.narvane.model.Meal;

public interface MealService extends GenericService<Meal, MealEntity> {

    Meal create(Meal meal);

}
