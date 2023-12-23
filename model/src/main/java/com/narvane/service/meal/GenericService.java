package com.narvane.service.meal;

import com.narvane.model.Model;

import java.util.List;
import java.util.Set;

public interface GenericService<M extends Model> {

    M create(M model);

    List<M> createAll(List<M> models);

    Set<M> createAll(Set<M> models);

}
