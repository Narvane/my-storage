package com.narvane.app.converter.impl.request;

import com.narvane.app.converter.RequestConverter;

import java.util.List;

public abstract class AbstractRequestConverterImpl<M, DTO> implements RequestConverter<M, DTO> {

    @Override
    public List<M> toModel(List<DTO> requestList) {
        return requestList.stream().map(this::toModel).toList();
    }

}
