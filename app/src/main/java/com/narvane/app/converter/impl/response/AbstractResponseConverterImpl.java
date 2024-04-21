package com.narvane.app.converter.impl.response;

import com.narvane.app.converter.ResponseConverter;

import java.util.List;

public abstract class AbstractResponseConverterImpl<M, VO> implements ResponseConverter<M, VO> {

    @Override
    public List<VO> toResponse(List<M> modelList) {
        return modelList.stream().map(this::toResponse).toList();
    }

}
