package com.narvane.model;

import java.util.UUID;

abstract class GenericModel implements Model {

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

    public GenericModel(boolean newIdentity) {
        this.newIdentity = newIdentity;
        if (this.newIdentity) {
            this.uuid = UUID.randomUUID();
        }
    }

    public UUID getUuid() {
        return uuid;
    }

}
