package com.narvane.infra.repository;

import com.narvane.infra.entity.FoodEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FoodRepository extends GenericRepository<FoodEntity, UUID> {
}
