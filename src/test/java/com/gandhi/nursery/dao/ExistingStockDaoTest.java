package com.gandhi.nursery.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.gandhi.nursery.entity.PlantsDetails;

/**
 * @author agunasekhar
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ExistingStockDaoTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	ExistingStockDao existingStockDao;

	@Test
	public void ExistingStockDao_ReadCompletePlantDetails_ReturnPlantsDetailsList() {
		entityManager.persist(preparePlantsDetails(10, "Rasalu", "NINE", "MANGO"));
		entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "MANGO"));
		List<PlantsDetails> plantsDetailsList = (List<PlantsDetails>) existingStockDao.findAll();
		assertEquals("Rasalu", plantsDetailsList.get(0).getName());
		assertEquals("Banginapalli", plantsDetailsList.get(1).getName());
	}
	
	@Test
	public void ExistingStockDao_ReadCompletePlantDetailsWhenDataIsNotThere_ReturnEmptyList() {
		List<PlantsDetails> plantsDetailsList = (List<PlantsDetails>) existingStockDao.findAll();
		assertTrue(plantsDetailsList.isEmpty());
	}
	
	@Test
	public void ExistingStockDao_ReadPlantDetailsByType_ReturnPlantsDetails() {
		entityManager.persist(preparePlantsDetails(10, "Rasalu", "NINE", "MANGO"));
		entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "MANGO"));
		entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "COCONUT"));
		List<PlantsDetails> plantsDetailsList = (List<PlantsDetails>) existingStockDao.findByType("MANGO");
		assertEquals("Rasalu", plantsDetailsList.get(0).getName());
		assertEquals("Banginapalli", plantsDetailsList.get(1).getName());
		assertEquals(2, plantsDetailsList.size());
	}
	
	@Test
	public void ExistingStockDao_ReadPlantDetailsByTypeWhereThatTypePlantsAreNotThere_ReturnPlantsDetails() {
		entityManager.persist(preparePlantsDetails(10, "Rasalu", "NINE", "MANGO"));
		entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "MANGO"));
		List<PlantsDetails> plantsDetailsList = (List<PlantsDetails>) existingStockDao.findByType("COCONUT");
		assertTrue(plantsDetailsList.isEmpty());
	}
	
	@Test
	public void ExistingStockDao_ReadPlantDetailsByNameAndType_ReturnPlantsDetails() {
		PlantsDetails p = entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "MANGO"));
		PlantsDetails saved = existingStockDao.findByNameAndType("Banginapalli", "MANGO");
		assertEquals(p, saved);
	}
	
	@Test
	public void ExistingStockDao_GivenValidTypeAndInvalidName_ReturnPlantsDetails() {
		entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "MANGO"));
		assertNull(existingStockDao.findByNameAndType("MANGO", "rasalu"));
		
	}
	
	@Test
	public void ExistingStockDao_UpdatePlantsDetails_ReturnPlantsDetails() {
		PlantsDetails plantDetails = entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "MANGO"));
		plantDetails.setQuantity(20);
		PlantsDetails updatedPlantDetails = existingStockDao.save(plantDetails);
		assertEquals(20, updatedPlantDetails.getQuantity());
	}
	
	
	@Test
	public void ExistingStockDao_DeletePlantDetailsById_ReturnPlantsDetails() {
		PlantsDetails plantsDetails = entityManager.persist(preparePlantsDetails(10, "Rasalu", "NINE", "MANGO"));
		entityManager.persist(preparePlantsDetails(10, "Banginapalli", "NINE", "MANGO"));
		existingStockDao.delete(plantsDetails.getId());
		List<PlantsDetails> plantsDetailsList = (List<PlantsDetails>) existingStockDao.findByType("MANGO");
		assertEquals("Banginapalli", plantsDetailsList.get(0).getName());
	}
	
	PlantsDetails preparePlantsDetails(int quantity, String...strings) {
		PlantsDetails plantDetails = new PlantsDetails();
		plantDetails.setName(strings[0]);
		plantDetails.setQuantity(quantity);
		plantDetails.setSize(strings[1]);
		plantDetails.setType(strings[2]);   
		return plantDetails;
	}
	
}