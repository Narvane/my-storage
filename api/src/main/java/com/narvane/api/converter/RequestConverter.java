package com.narvane.api.converter;

public interface RequestConverter<M, VO> {

    M toEntity(VO request);

}
