package com.gandhi.nursery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gandhi.nursery.entity.PlantsDetails;
import com.gandhi.nursery.exception.DataFormatException;
import com.gandhi.nursery.service.ExistingStockService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RequestMapping(value = "/plantDetails")
public class ExistingStockController extends AbstractRestHandler {
	
    @Autowired
    private ExistingStockService existingStockService;

    @RequestMapping(value = "/add",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void addPlantDetails(@RequestBody PlantsDetails plantDetails, HttpServletRequest request, HttpServletResponse response) {
        PlantsDetails savedPlantdetails = this.existingStockService.addPlantDetails(plantDetails);
        response.setHeader("Location", request.getRequestURL().append("/").append(savedPlantdetails.getId()).toString());
    }
    
    
    @RequestMapping(value = "/register",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public void registerPlantDetails(@RequestBody PlantsDetails user, HttpServletRequest request, HttpServletResponse response) {
    	PlantsDetails savedPlantdetails = this.existingStockService.addPlantDetails(user);
        response.setHeader("Location", request.getRequestURL().append("/").append(savedPlantdetails.getId()).toString());
    }

    @RequestMapping(value = "/read",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<PlantsDetails> getAllPlantDetails(HttpServletRequest request, HttpServletResponse response) {
        return this.existingStockService.getAllPlantDetails();
    }
    
    @RequestMapping(value = "/{type}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<PlantsDetails> getPlantsDetailsByType(@PathVariable("type") String type,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
    	List<PlantsDetails> plantDetailsList = this.existingStockService.getPlantsByType(type);
        return plantDetailsList;
    }
    
    @RequestMapping(value = "/{type}/{name}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    PlantsDetails getPlantDetailsByNameAndType(@PathVariable("type") String type, @PathVariable("name") String name,
                             HttpServletRequest request, HttpServletResponse response) throws Exception {
    	PlantsDetails plantDetails = this.existingStockService.getPlantByNameAndType(name, type);
    	checkResourceFound(plantDetails);
        return plantDetails;
    }

    @RequestMapping(value = "/{type}/{name}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateHotel(@PathVariable("type") String type, @PathVariable("name") String name, @RequestBody PlantsDetails plantsDetails,
                                 HttpServletRequest request, HttpServletResponse response) {
    	PlantsDetails plantDetails = this.existingStockService.getPlantByNameAndType(name, type);
        checkResourceFound(plantDetails);
        if (!type.equals(plantsDetails.getType()) || !name.equals(plantsDetails.getName()))
        	    throw new DataFormatException("Name or Type does not match");
        plantsDetails.setId(plantDetails.getId());
        this.existingStockService.updatePlantDetails(plantsDetails);
    }

    @RequestMapping(value = "/{type}/{name}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHotel(@PathVariable("type") String type, @PathVariable("name") String name, HttpServletRequest request,
                                 HttpServletResponse response) {
    	PlantsDetails plantDetails = this.existingStockService.getPlantByNameAndType(name, type);
    	checkResourceFound(plantDetails);
        this.existingStockService.deletePlantDetails(plantDetails.getId());
    }
}
