package com.narvane.infra.entity;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class AbstractEntityImpl implements AbstractEntity<UUID> {

    @Id
    @Column(name = "id", nullable = false)
    protected UUID id;

    private String userLogin;

    @Transient
    protected boolean newId;

    public AbstractEntityImpl(boolean newId) {
        this.newId = newId;
    }

    public boolean isNewId() {
        return newId;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public void setNew(boolean newId) {
        this.newId = newId;
    }

    @Override
    public String getUserLogin() {
        return userLogin;
    }

    @Override
    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

}
