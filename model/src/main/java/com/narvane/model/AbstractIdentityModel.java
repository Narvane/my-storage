package com.narvane.model;

import com.narvane.model.interfaces.IdentityModel;

import java.util.UUID;

abstract class AbstractIdentityModel implements IdentityModel {

    protected UUID uuid;

    private boolean newIdentity;

    @Override
    public void setNew() {
        this.newIdentity = true;
    }

    @Override
    public boolean isNew() {
        return newIdentity;
    }

    public AbstractIdentityModel(boolean newIdentity) {
        this.newIdentity = newIdentity;
        if (this.newIdentity) {
            this.uuid = UUID.randomUUID();
        }
    }

    public UUID getId() {
        return uuid;
    }

}

