package com.narvane.apimvc.exception.details;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Builder
@Data
public class ApiValidationExceptionDetails {
    private String baseMessage;
    private Map<String, String> details;
}

