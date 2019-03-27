package com.gandhi.nursery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gandhi.nursery.dao.ExistingStockDao;
import com.gandhi.nursery.entity.PlantsDetails;

/**
 * @author agunasekhar
 *
 */
@Service
public class ExistingStockServiceImpl implements ExistingStockService {
	@Autowired
	private ExistingStockDao existingStockDao;

	@Override
	public List<PlantsDetails> getAllPlantDetails() {
		return (List<PlantsDetails>) existingStockDao.findAll();
	}

	@Override
	public List<PlantsDetails> getPlantsByType(String type) {
		return existingStockDao.findByType(type);
	}

	@Override
	public PlantsDetails getPlantByNameAndType(String name, String type) {
		return existingStockDao.findByNameAndType(name, type);
	}

	@Override
	public PlantsDetails addPlantDetails(PlantsDetails plantsDetails) {
		return existingStockDao.save(plantsDetails);
	}

	@Override
	public PlantsDetails updatePlantDetails(PlantsDetails upadatePlantDetails) {
		return existingStockDao.save(upadatePlantDetails);
	}

	@Override
	public void deletePlantDetails(long id) {
		existingStockDao.delete(id);
	}
}
