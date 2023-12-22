package com.narvane.repository;

import com.narvane.model.Model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericRepository<M extends Model> {

    M create(M model);

    List<M> createAll(List<M> models);

    Optional<M> findById(UUID uuid);

}
