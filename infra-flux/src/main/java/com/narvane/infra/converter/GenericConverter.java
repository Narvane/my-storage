package com.narvane.infra.converter;

import com.narvane.infra.entity.AbstractEntity;
import com.narvane.model.Model;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericConverter<M extends Model, E extends AbstractEntity<?>> {

    Mono<E> toEntity(Mono<M> monoModel);

    Flux<E> toEntity(Flux<M> monoModel);

    Mono<M> toModel(Mono<E> entityObject);

    Flux<M> toModel(Flux<E> entityObject);

}
