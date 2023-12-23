package com.narvane.apimvc.converter;

import com.narvane.apimvc.dto.DTO;

import java.util.List;

public interface RequestConverter<M, VO> {

    M toModel(VO request);

    List<M> toModel(List<VO> requestList);

    Class<?> converterOf();

}
