package com.narvane.infra.repository;

import com.narvane.infra.entity.MealEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MealRepository extends GenericRepository<MealEntity, UUID> {

}
