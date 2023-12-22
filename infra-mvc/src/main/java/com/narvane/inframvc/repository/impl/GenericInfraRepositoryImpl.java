package com.narvane.inframvc.repository.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.AbstractEntity;
import com.narvane.inframvc.repository.GenericJpaRepository;
import com.narvane.model.Model;
import com.narvane.repository.GenericRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public List<M> createAll(List<M> models) {
        var savedModels = new ArrayList<M>();

        models.forEach(model -> {
            E entity = converter.toEntity(model);
            if (entity.isNew()) {
                this.create(model);
            }
            savedModels.add(this.findById(entity.getId()).orElse(null));
        });

        return savedModels;
    }

    @Override
    public Optional<M> findById(UUID uuid) {
        return jpaRepository.findById(uuid).map(converter::toModel);
    }

}
