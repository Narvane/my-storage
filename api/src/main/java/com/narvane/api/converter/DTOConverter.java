package com.narvane.api.converter;

/* Use directly this interface if you use the same VO for request and response*/
public interface DTOConverter<M, VO> extends RequestConverter<M, VO>, ResponseConverter<M, VO> {


}
