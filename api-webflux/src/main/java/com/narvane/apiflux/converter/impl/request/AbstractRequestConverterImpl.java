package com.narvane.apiflux.converter.impl.request;

import com.narvane.apiflux.converter.RequestConverter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractRequestConverterImpl<M, DTO> implements RequestConverter<M, DTO> {

    @Override
    public Mono<M> toModel(Mono<DTO> monoRequest) {
        return monoRequest.map(this::toModel);
    }

    @Override
    public Flux<M> toModel(Flux<DTO> fluxRequest) {
        return fluxRequest.map(this::toModel);
    }

    protected abstract M toModel(DTO entity);

}
