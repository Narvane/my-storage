package com.narvane.repository;

import com.narvane.model.interfaces.Model;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface GenericRepository<M extends Model> {

    M create(M model);

    M update(M model);

    List<M> createAll(List<M> models);

    Set<M> createAll(Set<M> models);

    Optional<M> findById(UUID uuid);

}
