package com.narvane.model.infra.repository;

import com.narvane.model.infra.entity.AbstractEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface GenericRepository<E extends AbstractEntity<ID>, ID> extends ReactiveCrudRepository<E, ID> {

}
