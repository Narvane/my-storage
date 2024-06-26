package com.narvane.infra.repository.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.AbstractEntity;
import com.narvane.infra.repository.jpa.GenericJpaRepository;
import com.narvane.model.interfaces.Model;
import com.narvane.repository.GenericRepository;

import java.util.*;

public class GenericInfraRepositoryImpl<M extends Model, E extends AbstractEntity<UUID>> implements GenericRepository<M> {

    protected final GenericConverter<M, E> converter;
    protected final GenericJpaRepository<E, UUID> jpaRepository;

    public GenericInfraRepositoryImpl(GenericJpaRepository<E, UUID> jpaRepository, GenericConverter<M, E> converter) {
        this.converter = converter;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public M create(M model) {
        E entity = converter.toEntity(model);
        return converter.toModel(jpaRepository.save(entity));
    }

    @Override
    public M update(M model) {
        E entity = converter.toEntity(model);
        return converter.toModel(jpaRepository.save(entity));
    }

    @Override
    public List<M> createAll(List<M> models) {
        var savedModels = new ArrayList<M>();

        models.forEach(model -> {
            E entity = converter.toEntity(model);
            if (entity.isNewId()) {
                savedModels.add(this.create(model));
            } else {
                savedModels.add(this.findById(entity.getId()).orElse(null));
            }
        });

        return savedModels;
    }

    @Override
    public Set<M> createAll(Set<M> models) {
        return new HashSet<>(this.createAll(models.stream().toList()));
    }

    @Override
    public Optional<M> findById(UUID uuid) {
        return jpaRepository.findById(uuid).map(converter::toModel);
    }

}
