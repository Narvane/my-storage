package com.narvane.inframvc.repository.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.FoodEntity;
import com.narvane.inframvc.repository.FoodInfraRepository;
import com.narvane.inframvc.repository.jpa.GenericJpaRepository;
import com.narvane.model.Food;
import com.narvane.repository.FoodRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class FoodInfraRepositoryImpl extends GenericInfraRepositoryImpl<Food, FoodEntity> implements FoodRepository, FoodInfraRepository {

    public FoodInfraRepositoryImpl(GenericJpaRepository<FoodEntity, UUID> repository, GenericConverter<Food, FoodEntity> converter) {
        super(repository, converter);
    }

}
