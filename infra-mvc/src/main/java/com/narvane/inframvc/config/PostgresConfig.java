package com.narvane.inframvc.config;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.inframvc.repository.FoodInfraRepository;
import com.narvane.inframvc.repository.GenericJpaRepository;
import com.narvane.inframvc.repository.impl.FoodInfraRepositoryImpl;
import com.narvane.inframvc.repository.impl.MealInfraRepositoryImpl;
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

import java.util.UUID;

@EntityScan({"com.narvane.inframvc.entity"})
@Configuration
@EnableJpaRepositories({"com.narvane.inframvc.repository"})
public class PostgresConfig {

    @Bean
    FoodRepository foodRepository(final GenericConverter<Food, FoodEntity> converter,
                                  final GenericJpaRepository<FoodEntity, UUID> repository) {
        return new FoodInfraRepositoryImpl(repository, converter);
    }

    @Bean
    MealRepository mealRepository(final GenericConverter<Meal, MealEntity> converter,
                                  final GenericJpaRepository<MealEntity, UUID> repository,
                                  final FoodInfraRepository foodInfraRepository) {
        return new MealInfraRepositoryImpl(converter, repository, foodInfraRepository);
    }

    @Bean
    MealService mealService(final MealRepository mealRepository, final FoodRepository foodRepository) {
        return new MealServiceImpl(mealRepository, foodRepository);
    }

}