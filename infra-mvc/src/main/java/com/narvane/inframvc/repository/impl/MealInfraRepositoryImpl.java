package com.narvane.inframvc.repository.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.inframvc.repository.FoodInfraRepository;
import com.narvane.inframvc.repository.GenericJpaRepository;
import com.narvane.inframvc.repository.MealInfraRepository;
import com.narvane.model.Meal;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MealInfraRepositoryImpl extends GenericInfraRepositoryImpl<Meal, MealEntity> implements MealInfraRepository {

    private final FoodInfraRepository foodInfraRepository;

    public MealInfraRepositoryImpl(GenericConverter<Meal, MealEntity> converter,
                                   GenericJpaRepository<MealEntity, UUID> repository,
                                   FoodInfraRepository foodInfraRepository) {
        super(repository, converter);
        this.foodInfraRepository = foodInfraRepository;
    }

    /*public Meal create(Meal meal) {
        var mealEntity = converter.toEntity(meal);

        var createdFoods = foodInfraRepository.createAll(mealEntity.getFoods());

        jpaRepository.saveAndFlush(mealEntity);

        //Necessary?
        mealEntity.setFoods(createdFoods);

        return converter.toModel(mealEntity);
    }*/

}
