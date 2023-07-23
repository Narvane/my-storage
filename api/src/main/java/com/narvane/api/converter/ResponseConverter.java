package com.narvane.api.converter;

import reactor.core.publisher.Mono;

public interface ResponseConverter<M, VO> {

    Mono<VO> toVO(Mono<M> monoModel);

}
