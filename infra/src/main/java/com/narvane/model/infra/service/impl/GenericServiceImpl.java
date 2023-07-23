package com.narvane.model.infra.service.impl;

import com.narvane.model.Model;
import com.narvane.model.infra.converter.GenericConverter;
import com.narvane.model.infra.entity.AbstractEntity;
import com.narvane.model.infra.repository.GenericRepository;
import com.narvane.model.infra.service.GenericService;

import java.util.UUID;

public class GenericServiceImpl<M extends Model, E extends AbstractEntity<UUID>> implements GenericService<M, E> {

    protected final GenericConverter<M, E> converter;
    protected final GenericRepository<E, UUID> repository;


    public GenericServiceImpl(GenericConverter<M, E> converter, GenericRepository<E, UUID> repository) {
        this.converter = converter;
        this.repository = repository;
    }

}
