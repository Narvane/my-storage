package com.narvane.infra.repository.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.FoodEntity;
import com.narvane.infra.repository.FoodInfraRepository;
import com.narvane.infra.repository.jpa.GenericJpaRepository;
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
