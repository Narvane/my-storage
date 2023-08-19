package com.narvane.inframvc.converter.impl;

import com.narvane.inframvc.converter.GenericConverter;
import com.narvane.inframvc.entity.AbstractEntity;
import com.narvane.model.Model;

import java.util.List;

public abstract class AbstractConverterImpl<M extends Model, E extends AbstractEntity<?>> implements GenericConverter<M, E> {

    @Override
    public List<E> toEntities(List<M> modelList) {
        return modelList.stream().map(this::toEntity).toList();
    }

    @Override
    public List<M> toModels(List<E> entityList) {
        return entityList.stream().map(this::toModel).toList();
    }

}
