package com.narvane.service.meal;

import com.narvane.model.interfaces.Model;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface GenericService<M extends Model> {

    M create(M model);

    M update(M model);

    M findById(UUID id);

    List<M> createOrUpdateAll(List<M> models);

    Set<M> createOrUpdateAll(Set<M> models);

}
