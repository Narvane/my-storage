package com.narvane.model.infra.entity;

public interface AbstractEntity<ID> {

    ID getId();

    void setId(ID id);

}
