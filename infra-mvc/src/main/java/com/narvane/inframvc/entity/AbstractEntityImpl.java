package com.narvane.inframvc.entity;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public abstract class AbstractEntityImpl implements AbstractEntity<UUID> {

    @Id
    @Column(name = "id", nullable = false)
    protected UUID id;

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

}
