package com.narvane.infra.repository.jpa;

import com.narvane.infra.entity.FoodEntity;

import java.util.UUID;

public interface FoodJpaRepository extends GenericJpaRepository<FoodEntity, UUID> {
}
