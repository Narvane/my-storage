package com.narvane.apimvc.converter;

import java.util.List;

public interface ResponseConverter<M, DTO> {

    DTO toResponse(M model);

    List<DTO> toResponse(List<M> modelList);

}
