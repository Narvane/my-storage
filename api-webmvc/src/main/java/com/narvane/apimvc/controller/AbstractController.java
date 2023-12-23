package com.narvane.apimvc.controller;

import com.narvane.apimvc.converter.RequestConverter;
import com.narvane.apimvc.converter.ResponseConverter;

import java.util.List;

public class AbstractController<M> {

    private List<RequestConverter<M, ?>> requestConverters;
    private List<ResponseConverter<M, ?>> responseConverters;

    protected RequestConverter<M, ?> getRequestConverter(Class<?> converterOf) {
        for (RequestConverter<M, ?> converter : requestConverters) {
            if (converter.converterOf() == converterOf) {
                return converter;
            }
        }
        throw new RuntimeException("Not founded converter");
    }

    protected ResponseConverter<M, ?> getResponseConverter(Class<?> converterOf) {
        for (ResponseConverter<M, ?> converter : responseConverters) {
            if (converter.converterOf() == converterOf) {
                return converter;
            }
        }
        throw new RuntimeException("Not founded converter");
    }

}
