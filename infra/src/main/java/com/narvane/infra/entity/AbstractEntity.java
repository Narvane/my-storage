package com.narvane.infra.entity;

public interface AbstractEntity<ID> {

    ID getId();

    void setId(ID id);

    boolean isNewId();

    void setNew(boolean newId);

    String getUserLogin();

    void setUserLogin(String userLogin);

}

