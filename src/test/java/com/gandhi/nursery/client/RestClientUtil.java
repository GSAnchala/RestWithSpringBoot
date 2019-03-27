package com.gandhi.nursery.client;

/**
 * @author agunasekhar
 *
 */
public class RestClientUtil {
    
	/*public void getAllPlantsDetailsDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/user/PlantsDetails";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<PlantsDetails[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, PlantsDetails[].class);
        PlantsDetails[] plantsDetailsList = responseEntity.getBody();
        for(PlantsDetails plantsDetails : plantsDetailsList) {
              System.out.println("Type:"+plantsDetails.getType()+", Name:"+plantsDetails.getName()
                      +", Quantity: "+plantsDetails.getQuantity());
        }
    }*/
}
