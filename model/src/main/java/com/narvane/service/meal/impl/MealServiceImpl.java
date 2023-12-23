package com.narvane.service.meal.impl;

import com.narvane.exception.MealWithoutFoodsException;
import com.narvane.model.Meal;
import com.narvane.repository.GenericRepository;
import com.narvane.service.food.FoodService;
import com.narvane.service.meal.MealService;

public class MealServiceImpl extends GenericServiceImpl<Meal> implements MealService {

    private final FoodService foodService;

    public MealServiceImpl(GenericRepository<Meal> repository, FoodService foodService) {
        super(repository);
        this.foodService = foodService;
    }

    @Override
    public Meal create(Meal meal) {

        if (meal.haveAnyFood()) {
            throw new MealWithoutFoodsException();
        }

        var createdFoods = this.foodService.createAll(meal.getFoods());
        meal.updateFoods(createdFoods);

        return super.create(meal);
    }

}
