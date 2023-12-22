package com.narvane.service.meal;

import com.narvane.model.Model;

public interface GenericService<M extends Model> {

    M create(M model);

}
