package com.narvane.apimvc.controller.converters;

import com.narvane.apimvc.converter.RequestConverter;
import com.narvane.apimvc.converter.ResponseConverter;
import com.narvane.apimvc.dto.CreateMealDTO;
import com.narvane.apimvc.dto.DTO;
import com.narvane.apimvc.dto.UpdateMealDTO;
import com.narvane.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MealConverters {

    private final List<RequestConverter<Meal, ? extends DTO>> requestConverters;
    private final List<ResponseConverter<Meal, ? extends DTO>> responseConverters;

    @Autowired
    public MealConverters(RequestConverter<Meal, CreateMealDTO.Request> createMealRequestConverter,
                          ResponseConverter<Meal, CreateMealDTO.Response> createMealResponseConverter,
                          RequestConverter<Meal, UpdateMealDTO.Request> updateMealRequestConverter,
                          ResponseConverter<Meal, UpdateMealDTO.Response> updateMealResponseConverter) {
        requestConverters = new ArrayList<>();
        responseConverters = new ArrayList<>();

        requestConverters.add(createMealRequestConverter);
        requestConverters.add(updateMealRequestConverter);

        responseConverters.add(createMealResponseConverter);
        responseConverters.add(updateMealResponseConverter);
    }

    public RequestConverter<Meal, ?> requestConverterFrom(Class<?> converterOf) {
        return Optional.ofNullable(requestConverters).flatMap(requestConverters -> requestConverters.stream()
                .filter(requestConverter -> requestConverter.converterOf() == converterOf).findFirst()).orElse(null);
    }

    public ResponseConverter<Meal, ?> responseConverterFrom(Class<?> converterOf) {
        return Optional.ofNullable(responseConverters).flatMap(responseConverters -> responseConverters.stream()
                .filter(responseConverter -> responseConverter.converterOf() == converterOf).findFirst()).orElse(null);
    }

}
