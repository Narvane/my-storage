package com.narvane.inframvc.service.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.AbstractEntity;
import com.narvane.inframvc.service.GenericService;
import com.narvane.model.Model;
import com.narvane.inframvc.repository.GenericRepository;

import java.util.UUID;

public class GenericServiceImpl<M extends Model, E extends AbstractEntity<UUID>> implements GenericService<M, E> {

    protected final GenericConverter<M, E> converter;
    protected final GenericRepository<E, UUID> repository;


    public GenericServiceImpl(GenericConverter<M, E> converter, GenericRepository<E, UUID> repository) {
        this.converter = converter;
        this.repository = repository;
    }

}
