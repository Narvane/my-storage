package com.narvane.infra.entity;

import org.springframework.data.domain.Persistable;

public interface AbstractEntity<ID> extends Persistable<ID> {

    ID getId();

    void setId(ID id);

    boolean exist();

    void setNew();

}
