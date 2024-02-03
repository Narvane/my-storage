package com.narvane.service.meal.impl;

import com.narvane.exception.ModelNotFoundException;
import com.narvane.model.interfaces.Model;
import com.narvane.repository.GenericRepository;
import com.narvane.service.meal.GenericService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
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
    public M update(M model) {
        return repository.update(model);
    }

    @Override
    public M findById(UUID id) {
        Optional<M> modelOptional = repository.findById(id);

        return modelOptional.orElseThrow(() -> {
            throw new ModelNotFoundException();
        });
    }

    @Override
    public List<M> createOrUpdateAll(List<M> models) {
        return models.stream().map(this::create).collect(Collectors.toList());
    }

    @Override
    public Set<M> createOrUpdateAll(Set<M> models) {
        return models.stream().map(this::create).collect(Collectors.toSet());
    }

}
