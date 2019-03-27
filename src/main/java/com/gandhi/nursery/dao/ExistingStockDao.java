package com.gandhi.nursery.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gandhi.nursery.entity.PlantsDetails;

/**
 * @author agunasekhar
 *
 */

public interface ExistingStockDao  extends CrudRepository<PlantsDetails, Long> {

	List<PlantsDetails> findByType(String type);

	PlantsDetails findByNameAndType(String name, String type);
}
