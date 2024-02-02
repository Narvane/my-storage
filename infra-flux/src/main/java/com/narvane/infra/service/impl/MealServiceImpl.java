package com.narvane.infra.service.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.FoodEntity;
import com.narvane.infra.entity.MealEntity;
import com.narvane.infra.entity.MealFoodsEntity;
import com.narvane.infra.repository.FoodRepository;
import com.narvane.infra.repository.MealFoodsRepository;
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
    private final MealFoodsRepository mealFoodsRepository;
    private final GenericConverter<Food, FoodEntity> foodConverter;

    @Autowired
    public MealServiceImpl(
            GenericConverter<Meal, MealEntity> converter,
            MealRepository repository,
            FoodRepository foodRepository,
            MealFoodsRepository mealFoodsRepository,
            GenericConverter<Food, FoodEntity> foodConverter) {
        super(converter, repository);
        this.foodRepository = foodRepository;
        this.foodConverter = foodConverter;
        this.mealFoodsRepository = mealFoodsRepository;
    }

    public Mono<Meal> create(Mono<Meal> monoMeal) {
        /*return monoMeal.flatMap(meal -> {
            var mealEntityMono = converter.toEntity(Mono.just(meal));
            var foodFluxEntities = foodConverter.toEntity(Flux.fromIterable(meal.getPortions())).collectList();

            return mealEntityMono.zipWith(foodFluxEntities).flatMap(tuple -> {
                var mealEntity = tuple.getT1();
                var foodsEntities = tuple.getT2();

                var savedMealEntityMono = repository.save(mealEntity);
                var savedMealMono = converter.toModel(savedMealEntityMono);

                return savedMealMono.flatMap(savedMeal -> {
                    var existentFoods = foodsEntities.stream().filter(FoodEntity::exist).toList();
                    var newFoods = foodsEntities.stream().filter(FoodEntity::isNew).toList();

                    var newSavedFoodEntitiesFlux = foodRepository.saveAll(newFoods);

                    var existentFoodEntities = mealFoodsRepository.saveAll(
                            existentFoods.stream()
                                    .map(existentFoodEntity -> new MealFoodsEntity(savedMeal.getUuid(), existentFoodEntity.getId()))
                                    .toList())
                            .flatMap(mealFoodsEntity -> foodRepository.findById(mealFoodsEntity.getFoodId()));

                    var savedFoodFlux = foodConverter.toModel(Flux.merge(newSavedFoodEntitiesFlux, existentFoodEntities));
                    return savedFoodFlux.doOnNext(savedMeal::addPortion).then(Mono.just(savedMeal));
                });
            });
        });*/
        return null;
    }

}
