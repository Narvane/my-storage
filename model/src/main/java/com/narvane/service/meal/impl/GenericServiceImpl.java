package com.narvane.service.meal.impl;

import com.narvane.model.Model;
import com.narvane.repository.GenericRepository;
import com.narvane.service.meal.GenericService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GenericServiceImpl<M extends Model> implements GenericService<M> {

    protected GenericRepository<M> repository;

    // Idea Generic Validator & agroup error messages

    public GenericServiceImpl(GenericRepository<M> repository) {
        this.repository = repository;
    }

    @Override
    public M create(M model) {
        return repository.create(model);
    }

    @Override
    public List<M> createAll(List<M> models) {
        return models.stream().map(this::create).collect(Collectors.toList());
    }

    @Override
    public Set<M> createAll(Set<M> models) {
        return models.stream().map(this::create).collect(Collectors.toSet());
    }

}
