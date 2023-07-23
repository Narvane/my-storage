package com.narvane.model.infra.service.impl;

import com.narvane.model.Meal;
import com.narvane.model.infra.converter.GenericConverter;
import com.narvane.model.infra.entity.MealEntity;
import com.narvane.model.infra.repository.GenericRepository;
import com.narvane.model.infra.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class MealServiceImpl extends GenericServiceImpl<Meal, MealEntity> implements MealService {

    @Autowired
    public MealServiceImpl(GenericConverter<Meal, MealEntity> converter, GenericRepository<MealEntity, UUID> repository) {
        super(converter, repository);
    }

    public Mono<Meal> create(Meal meal) {
        var mealEntity = converter.toEntity(meal);

        var savedMealEntity = repository.save(mealEntity);

        return converter.toModel(savedMealEntity);
    }

}
