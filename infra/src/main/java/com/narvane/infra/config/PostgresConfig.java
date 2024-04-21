package com.narvane.infra.config;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.FoodEntity;
import com.narvane.infra.entity.MealEntity;
import com.narvane.infra.repository.impl.FoodInfraRepositoryImpl;
import com.narvane.infra.repository.impl.MealInfraRepositoryImpl;
import com.narvane.infra.repository.jpa.FoodJpaRepository;
import com.narvane.infra.repository.jpa.MealJpaRepository;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import com.narvane.repository.FoodRepository;
import com.narvane.repository.MealRepository;
import com.narvane.service.food.FoodService;
import com.narvane.service.food.impl.FoodServiceImpl;
import com.narvane.service.meal.MealService;
import com.narvane.service.meal.impl.MealServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"com.narvane.infra.entity"})
@Configuration
@EnableJpaRepositories({"com.narvane.infra.repository"})
public class PostgresConfig {

    @Bean
    FoodRepository foodRepository(final GenericConverter<Food, FoodEntity> converter,
                                  final FoodJpaRepository repository) {
        return new FoodInfraRepositoryImpl(repository, converter);
    }

    @Bean
    MealRepository mealRepository(final GenericConverter<Meal, MealEntity> converter,
                                  final MealJpaRepository repository) {
        return new MealInfraRepositoryImpl(converter, repository);
    }

    @Bean
    FoodService foodService(final FoodRepository foodRepository) {
        return new FoodServiceImpl(foodRepository);
    }


    @Bean
    MealService mealService(final MealRepository mealRepository, final FoodService foodService) {
        return new MealServiceImpl(mealRepository, foodService);
    }

}