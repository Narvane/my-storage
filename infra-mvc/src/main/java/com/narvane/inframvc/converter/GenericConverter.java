package com.narvane.inframvc.converter;

import com.narvane.inframvc.entity.AbstractEntity;
import com.narvane.model.Model;

import java.util.List;

public interface GenericConverter<M extends Model, E extends AbstractEntity<?>> {

    E toEntity(M model);

    List<E> toEntities(List<M> modelList);

    M toModel(E entity);

    List<M> toModels(List<E> entityList);

}
