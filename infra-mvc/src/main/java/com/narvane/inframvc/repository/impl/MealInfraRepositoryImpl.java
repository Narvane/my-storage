package com.narvane.inframvc.repository.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.MealEntity;
import com.narvane.inframvc.repository.MealInfraRepository;
import com.narvane.inframvc.repository.jpa.MealJpaRepository;
import com.narvane.model.Meal;
import org.springframework.stereotype.Repository;

@Repository
public class MealInfraRepositoryImpl extends GenericInfraRepositoryImpl<Meal, MealEntity> implements MealInfraRepository {

    public MealInfraRepositoryImpl(GenericConverter<Meal, MealEntity> converter,
                                   MealJpaRepository repository) {
        super(repository, converter);
    }

}
