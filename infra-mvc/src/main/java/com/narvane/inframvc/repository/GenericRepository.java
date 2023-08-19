package com.narvane.inframvc.repository;

import com.narvane.inframvc.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface GenericRepository<E extends AbstractEntity<ID>, ID> extends JpaRepository<E, ID> {

}
