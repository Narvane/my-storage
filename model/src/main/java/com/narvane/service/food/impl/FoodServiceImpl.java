package com.narvane.service.food.impl;

import com.narvane.exception.OpaqueFoodException;
import com.narvane.model.Food;
import com.narvane.repository.GenericRepository;
import com.narvane.service.food.FoodService;
import com.narvane.service.meal.impl.GenericServiceImpl;

public class FoodServiceImpl extends GenericServiceImpl<Food> implements FoodService {

    public FoodServiceImpl(GenericRepository<Food> repository) {
        super(repository);
    }

    @Override
    public Food create(Food food) {

        if (food.isNew() && food.isEmptyNamed()) {
            throw new OpaqueFoodException();
        }

        return super.create(food);
    }

}
