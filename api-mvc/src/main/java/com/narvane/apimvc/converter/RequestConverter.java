package com.narvane.apimvc.converter;

import java.util.List;

public interface RequestConverter<M, VO> {

    M toModel(VO request);

    List<M> toModel(List<VO> requestList);

}
