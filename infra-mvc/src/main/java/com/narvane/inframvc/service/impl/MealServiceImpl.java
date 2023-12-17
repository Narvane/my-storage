package com.narvane.inframvc.service.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.inframvc.repository.FoodRepository;
import com.narvane.inframvc.repository.GenericRepository;
import com.narvane.inframvc.service.MealService;
import com.narvane.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class MealServiceImpl extends GenericServiceImpl<Meal, MealEntity> implements MealService {

    private final FoodRepository foodRepository;

    @Autowired
    public MealServiceImpl(
            GenericConverter<Meal, MealEntity> converter,
            GenericRepository<MealEntity, UUID> repository,
            FoodRepository foodRepository) {
        super(converter, repository);
        this.foodRepository = foodRepository;
    }

    @Override
    @Transactional
    public Meal create(Meal meal) {
        var mealEntity = converter.toEntity(meal);
        var savedFoods = new ArrayList<FoodEntity>();

        mealEntity.getFoods()
                .forEach(foodEntity -> {
                    if (foodEntity.isNew()) {
                        foodRepository.save(foodEntity);
                    }
                    savedFoods.add(foodRepository.findById(foodEntity.getId()).orElse(null));
                });

        repository.saveAndFlush(mealEntity);

        mealEntity.setFoods(savedFoods);

        return converter.toModel(mealEntity);
    }

}
