To Run the Application

1. mvn clean install
2. mvn clean eclipse:eclipse
3. mvn clean package
4. mvn spring-boot:run  //this will start the spring boot application 


Testing The application
Open Chrome Browser
1.Add ARC extension to chrome
2.Open ARC
Now You are ready with the enviroment

POST:
	url: http://localhost:8888/plantDetails
	pass:
		{
			"name": "BANGAN",
			"type": "MANGO",
			"size": "TWENTYONE",
			"quantity": 20
		}
	response:201 created

GET:
//get all the list of plant details
	url: http://localhost:8888/plantDetails	
	response:200 Ok
	[
		{
			"id": 1,
			"name": "BANGAN",
			"type": "MANGO",
			"size": "TWENTYONE",
			"quantity": 20
		}
	],
GET:	
//get the plant details By Type
    url:http://localhost:8888/plantDetails/MANGO
	response:200 Ok
	[
		{
			"id": 1,
			"name": "BANGAN",
			"type": "MANGO",
			"size": "TWENTYONE",
			"quantity": 20
		}
	],
GET:
// get palnts details by Type and name
	url:http://localhost:8888/plantDetails/MANGO/BANGAN
	response:200 Ok
	[
		{
			"id": 1,
			"name": "BANGAN",
			"type": "MANGO",
			"size": "TWENTYONE",
			"quantity": 20
		}
	],
PUT:
//Updating palnt details
	url:http://localhost:8888/plantDetails/MANGO/BANGAN 
		pass:
		{
			"name": "BANGAN",
			"type": "MANGO",
			"size": "TWENTYONE",
			"quantity": 10
		}
DELETE:
//Deletting particular plants Details
	url:http://localhost:8888/plantDetails/MANGO/BANGAN
	response:204 No Content
	
	
	
	
	