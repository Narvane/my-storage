package com.narvane.apiflux.converter;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RequestConverter<M, VO> {

    Mono<M> toModel(Mono<VO> monoRequest);

    Flux<M> toModel(Flux<VO> fluxRequest);

}
