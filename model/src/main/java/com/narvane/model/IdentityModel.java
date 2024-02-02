package com.narvane.model;

import java.util.UUID;

public interface IdentityModel extends Model {

    void setNew();

    boolean isNew();

    public UUID getUuid();

}
