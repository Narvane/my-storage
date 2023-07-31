package com.narvane.api.converter;

public interface RequestConverter<M, VO> {

    M toModel(VO request);

}
