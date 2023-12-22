package com.narvane.service.meal.impl;

import com.narvane.model.Model;
import com.narvane.repository.GenericRepository;
import com.narvane.service.meal.GenericService;

public class GenericServiceImpl<M extends Model> implements GenericService<M> {

    protected GenericRepository<M> repository;

    public GenericServiceImpl(GenericRepository<M> repository) {
        this.repository = repository;
    }

    @Override
    public M create(M model) {
        return repository.create(model);
    }

}
