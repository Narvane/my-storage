package com.narvane.inframvc.repository;

import com.narvane.inframvc.entity.AbstractEntity;
import com.narvane.model.interfaces.Model;

import java.util.UUID;

public interface GenericInfraRepository<M extends Model, E extends AbstractEntity<UUID>> {

}
