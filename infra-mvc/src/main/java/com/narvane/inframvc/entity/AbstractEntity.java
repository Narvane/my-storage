package com.narvane.inframvc.entity;

public interface AbstractEntity<ID> {

    ID getId();

    void setId(ID id);

    boolean isNewId();

    void setNew(boolean newId);

}

