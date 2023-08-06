package com.narvane.api.converter;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ResponseConverter<M, DTO> {

    Mono<DTO> toResponse(Mono<M> monoModel);

    Flux<DTO> toResponse(Flux<M> fluxModel);

}
