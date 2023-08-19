package com.narvane.inframvc.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan({"com.narvane.inframvc.entity"})
@Configuration
@EnableJpaRepositories({"com.narvane.inframvc.repository"})
public class PostgresConfig {

}