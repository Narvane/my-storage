package com.narvane.model.infra.converter;

import com.narvane.model.Model;
import com.narvane.model.infra.entity.AbstractEntity;
import reactor.core.publisher.Mono;

public interface GenericConverter<M extends Model, E extends AbstractEntity<?>> {

    E toEntity(M modelObject);

    Mono<M> toModel(Mono<E> entityObject);

}
