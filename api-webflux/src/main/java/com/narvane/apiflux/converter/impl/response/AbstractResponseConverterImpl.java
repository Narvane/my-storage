package com.narvane.apiflux.converter.impl.response;

import com.narvane.apiflux.converter.ResponseConverter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class AbstractResponseConverterImpl<M, VO> implements ResponseConverter<M, VO> {


    @Override
    public Mono<VO> toResponse(Mono<M> monoModel) {
        return monoModel.map(this::toResponse);
    }

    @Override
    public Flux<VO> toResponse(Flux<M> fluxModel) {
        return fluxModel.map(this::toResponse);
    }

    protected abstract VO toResponse(M model);

}
