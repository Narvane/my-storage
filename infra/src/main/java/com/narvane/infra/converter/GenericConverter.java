package com.narvane.infra.converter;

import com.narvane.infra.entity.AbstractEntity;
import com.narvane.model.Model;

public interface GenericConverter<M extends Model, E extends AbstractEntity<?>> {

    E toEntity(M modelObject);

    M toModel(E entityObject);

}
