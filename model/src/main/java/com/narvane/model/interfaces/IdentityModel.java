package com.narvane.model.interfaces;

import java.util.UUID;

public interface IdentityModel extends Model {

    void setNew();

    boolean isNew();

    public UUID getId();

}
