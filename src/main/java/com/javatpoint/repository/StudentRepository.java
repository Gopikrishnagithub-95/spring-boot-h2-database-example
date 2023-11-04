package com.javatpoint.repository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.javatpoint.model.GuideLinesEntity;
@EnableJpaRepositories
public interface StudentRepository extends CrudRepository<GuideLinesEntity, Integer>
{
}
