package com.narvane.infra.repository;

import com.narvane.infra.entity.AbstractEntity;
import com.narvane.model.interfaces.Model;

import java.util.UUID;

public interface GenericInfraRepository<M extends Model, E extends AbstractEntity<UUID>> {

}
