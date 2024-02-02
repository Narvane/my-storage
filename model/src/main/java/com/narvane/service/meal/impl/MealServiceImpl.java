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

        if (!meal.haveAnyFood()) {
            throw new MealWithoutFoodsException();
        }
        this.foodService.createOrUpdateAll(
                meal.getPortions().getFoodSet()
        );
        //Verificar se precisa ser a entidade managed ou só mandar o ID já é valido
        return super.create(meal);
    }

    @Override
    public Meal update(Meal updatedMeal) {
        Meal mealToUpdate = this.findById(updatedMeal.getUuid());
        mealToUpdate.update(updatedMeal);
        return super.update(mealToUpdate);
    }

}
