package com.narvane.service.meal.impl;

import com.narvane.model.Meal;
import com.narvane.repository.FoodRepository;
import com.narvane.repository.GenericRepository;
import com.narvane.service.meal.MealService;

public class MealServiceImpl extends GenericServiceImpl<Meal> implements MealService {

    private final FoodRepository foodRepository;

    public MealServiceImpl(GenericRepository<Meal> repository, FoodRepository foodRepository) {
        super(repository);
        this.foodRepository = foodRepository;
    }

    @Override
    public Meal create(Meal meal) {
        var createdFoods = this.foodRepository.createAll(meal.getFoods());
        meal.updateFoods(createdFoods);

        return repository.create(meal);
    }

}
