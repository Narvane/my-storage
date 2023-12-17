package com.narvane.inframvc.entity;

public interface AbstractEntity<ID> {

    ID getId();

    void setId(ID id);

    default boolean isNew() {
        return getId() == null;
    }

}

