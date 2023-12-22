package com.narvane.service.meal.impl;

import com.narvane.model.Meal;
import com.narvane.repository.FoodRepository;
import com.narvane.repository.GenericRepository;
import com.narvane.service.meal.MealService;

//TODO Inject Bean & do generic impl
public class MealServiceImpl extends GenericServiceImpl<Meal> implements MealService {

    private final FoodRepository foodRepository;

    public MealServiceImpl(GenericRepository<Meal> repository, FoodRepository foodRepository) {
        super(repository);
        this.foodRepository = foodRepository;
    }

    @Override
    public Meal create(Meal model) {
        var createdFoods = this.foodRepository.createAll(model.getFoods());
        var createdMeal = repository.create(model);

        createdFoods.forEach(createdMeal::addFoods);

        return createdMeal;
    }

}
