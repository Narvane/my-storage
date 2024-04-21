package com.narvane.infra.repository.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.MealEntity;
import com.narvane.infra.repository.MealInfraRepository;
import com.narvane.infra.repository.jpa.MealJpaRepository;
import com.narvane.model.Meal;
import org.springframework.stereotype.Repository;

@Repository
public class MealInfraRepositoryImpl extends GenericInfraRepositoryImpl<Meal, MealEntity> implements MealInfraRepository {

    public MealInfraRepositoryImpl(GenericConverter<Meal, MealEntity> converter,
                                   MealJpaRepository repository) {
        super(repository, converter);
    }

}
