package com.narvane.infra.converter.impl;

import com.narvane.infra.converter.GenericConverter;
import com.narvane.infra.entity.AbstractEntity;
import com.narvane.model.Model;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractConverterImpl<M extends Model, E extends AbstractEntity<?>> implements GenericConverter<M, E> {

    @Override
    public Mono<E> toEntity(Mono<M> monoModel) {
        return monoModel.map(this::toEntityHandlingNew);
    }

    @Override
    public Flux<E> toEntity(Flux<M> fluxModel) {
        return fluxModel.map(this::toEntityHandlingNew);
    }

    @Override
    public Mono<M> toModel(Mono<E> monoEntity) {
        return monoEntity.map(this::toModel);
    }

    @Override
    public Flux<M> toModel(Flux<E> fluxEntity) {
        return fluxEntity.map(this::toModel);
    }

    private E toEntityHandlingNew(M model) {
        E entity = toEntity(model);
        entity.setNew();
        return entity;
    }

    protected abstract E toEntity(M model);

    protected abstract M toModel(E entity);
}
