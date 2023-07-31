package com.narvane.infra.service.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.FoodEntity;
import com.narvane.infra.entity.MealEntity;
import com.narvane.infra.repository.FoodRepository;
import com.narvane.infra.repository.MealRepository;
import com.narvane.infra.service.MealService;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MealServiceImpl extends GenericServiceImpl<Meal, MealEntity> implements MealService {

    private final FoodRepository foodRepository;
    private final GenericConverter<Food, FoodEntity> foodConverter;

    @Autowired
    public MealServiceImpl(
            GenericConverter<Meal, MealEntity> converter,
            MealRepository repository,
            FoodRepository foodRepository,
            GenericConverter<Food, FoodEntity> foodConverter) {
        super(converter, repository);
        this.foodRepository = foodRepository;
        this.foodConverter = foodConverter;
    }

    public Mono<Meal> create(Meal meal) {
        var mealEntity = converter.toEntity(meal);

        var savedMealEntityMono = repository.save(mealEntity);

        var savedFoodsFlux = Flux.fromIterable(meal.getFoods())
                .flatMap(food -> {
                    var foodEntity = foodConverter.toEntity(food);
                    foodEntity.setMealId(mealEntity.getId());
                    return foodRepository.save(foodEntity);
                })
                .collectList();

        return savedMealEntityMono.zipWith(savedFoodsFlux)
                .map(tuple -> {
                    var savedMealEntity = tuple.getT1();
                    var savedFoodsEntities = tuple.getT2();

                    var mealResponse = converter.toModel(savedMealEntity);

                    savedFoodsEntities.stream().map(foodConverter::toModel).forEach(mealResponse::addFood);
                    return mealResponse;
                });
    }

}
