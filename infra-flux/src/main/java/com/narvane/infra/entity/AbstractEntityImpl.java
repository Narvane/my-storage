package com.narvane.infra.entity;

import org.springframework.data.annotation.Transient;

import java.util.UUID;

public abstract class AbstractEntityImpl implements AbstractEntity<UUID> {

    @Transient
    protected boolean _new;

    @Override
    public boolean isNew() {
        return this._new;
    }

    @Override
    public boolean exist() {
        return !this._new;
    }

    public void setNew() {
        this._new = true;
        this.setId(UUID.randomUUID());
    }

}
