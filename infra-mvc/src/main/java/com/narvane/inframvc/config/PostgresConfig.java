package com.narvane.inframvc.config;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.inframvc.repository.impl.FoodInfraRepositoryImpl;
import com.narvane.inframvc.repository.impl.MealInfraRepositoryImpl;
import com.narvane.inframvc.repository.jpa.FoodJpaRepository;
import com.narvane.inframvc.repository.jpa.MealJpaRepository;
import com.narvane.model.Food;
import com.narvane.model.Meal;
import com.narvane.repository.FoodRepository;
import com.narvane.repository.MealRepository;
import com.narvane.service.meal.MealService;
import com.narvane.service.meal.impl.MealServiceImpl;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"com.narvane.inframvc.entity"})
@Configuration
@EnableJpaRepositories({"com.narvane.inframvc.repository"})
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
    MealService mealService(final MealRepository mealRepository, final FoodRepository foodRepository) {
        return new MealServiceImpl(mealRepository, foodRepository);
    }

}