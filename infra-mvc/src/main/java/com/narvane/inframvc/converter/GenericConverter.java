package com.narvane.inframvc.converter;

import com.narvane.inframvc.entity.AbstractEntity;
import com.narvane.model.interfaces.Model;

import java.util.List;
import java.util.Set;

public interface GenericConverter<M extends Model, E extends AbstractEntity<?>> {

    E toEntity(M model);

    List<E> toEntities(List<M> modelList);

    M toModel(E entity);

    List<M> toModels(List<E> entityList);

    Set<E> toEntities(Set<M> modelList);

    Set<M> toModels(Set<E> entityList);

}
