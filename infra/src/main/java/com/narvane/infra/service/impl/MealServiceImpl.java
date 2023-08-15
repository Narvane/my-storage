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

    public Mono<Meal> create(Mono<Meal> monoMeal) {
        return monoMeal.flatMap(meal -> {
            var mealEntityMono = converter.toEntity(Mono.just(meal));
            var foodFluxEntities = foodConverter.toEntity(Flux.fromIterable(meal.getFoods())).collectList();

            return mealEntityMono.zipWith(foodFluxEntities).flatMap(tuple -> {
                var mealEntity = tuple.getT1();
                var foodsEntities = tuple.getT2();

                var savedMealEntityMono = repository.save(mealEntity);
                var savedMealMono = converter.toModel(savedMealEntityMono);

                return savedMealMono.flatMap(savedMeal -> {
                    foodsEntities.forEach(foodEntity -> foodEntity.setMealId(savedMeal.getUuid()));
                    var savedFoodEntitiesFlux = foodRepository.saveAll(foodsEntities);

                    var savedFoodFlux = foodConverter.toModel(savedFoodEntitiesFlux);
                    return savedFoodFlux.doOnNext(savedMeal::addFood).then(Mono.just(savedMeal));
                });
            });
        });
    }

}
