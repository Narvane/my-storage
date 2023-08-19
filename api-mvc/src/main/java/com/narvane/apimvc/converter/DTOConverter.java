package com.narvane.apimvc.converter;

/* Use directly this interface if you use the same VO for request and response*/
public interface DTOConverter<M, DTO> extends RequestConverter<M, DTO>, ResponseConverter<M, DTO> {


}
