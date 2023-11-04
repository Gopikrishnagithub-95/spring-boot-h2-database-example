package com.javatpoint.repository;
import java.util.List;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.model.SubRegionEntity;
@Repository
public interface SubRegionRepository extends CrudRepository<SubRegionEntity, Integer>
{

	List<SubRegionEntity> findAllById(Integer id);
}
