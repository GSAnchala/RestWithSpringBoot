package com.gandhi.nursery.service;

import java.util.List;

import com.gandhi.nursery.entity.PlantsDetails;

/**
 * @author agunasekhar
 *
 */
public interface ExistingStockService {
	
	List<PlantsDetails> getAllPlantDetails();

	List<PlantsDetails> getPlantsByType(String type);

	PlantsDetails getPlantByNameAndType(String name, String type);

	PlantsDetails addPlantDetails(PlantsDetails plantsDetails);

	PlantsDetails updatePlantDetails(PlantsDetails plantsDetails);

	void deletePlantDetails(long id);	
}
