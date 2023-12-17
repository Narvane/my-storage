package com.narvane.apimvc.converter.impl.request;

import com.narvane.apimvc.converter.RequestConverter;

import java.util.List;

public abstract class AbstractRequestConverterImpl<M, DTO> implements RequestConverter<M, DTO> {

    @Override
    public List<M> toModel(List<DTO> requestList) {
        return requestList.stream().map(this::toModel).toList();
    }

}
