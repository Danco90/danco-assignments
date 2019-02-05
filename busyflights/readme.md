# 'BusyFlights' - The Search engine for your cheap solutions : 'BUSYFLIGHTS-SERVICE' Springboot Microservice 
.

###1. configuration 


###2. Run

cd toughjet/target 

java -jar busyflights-0.0.1-SNAPSHOT.jar

###3. Testing (Automated mode) : Run Unit and Integration Tests and check Code Coverage
 3.2) For running tests use maven  :

	maven clean test


 3.2) For Code Coverage make sure to have the following requirements 
 -JaCoCo configured : JaCoCo-maven-plugin has to be added in pom.xml
 
 -SonarQube already installed, otherwise there's an available docker image 
 	
 3.2.1) Pull sonarqube image 	

	docker pull sonarqube
	
 3.2.1) Run daemon
	
	docker run -d --name sonarqube -p 9000:9000 -p 9092:9092 sonarqube
	
3.2.3) Open SonarQube dashboard

	http://localhost:9000	

3.2.4) Run test cases

    maven test
   
 
###4. Testing (Interactive mode) : Test Rest Services with REST CLIENT (required JSON RequestBody available in src/main/in)
* 4.1) Make sure to have already installed a rest client such as Postman or ADS (Advanced Rest Client)
the following micro-services UP and RUNNING by following the same procedure for step 2.

* 4.2) Make sure to have the following micro-services UP and RUNNING by following the same procedure for step 2.

Naming Server

      - eureka-naming-server
      
Ticket's Suppliers micro-services

      = crazyair-service (supplier1)
      - toughjet-service (supplier2)
      - other-service (supplierN)

In a rest client specify the headers 
	Content-Type=[{"key":"Content-Type","name":"Content-Type","value":"text/plain","description":"","type":"text"}] 
	
* 4.3) invoke the following rest service 


Example 1 - Search flight solutions for flight WAW (Warsaw) - WRO (Wroclaw) :

 PUT http://localhost:8030/api/busyflights-service/search
			
			{
			  "origin":"WAW",
			  "destination":"WRO",
			  "departureDate":"2018-12-28",
			  "returnDate":"2011-01-01",
			  "numberOfPassengers":1
			}

###5. Remaining Tasks :  

- Adding Integration Tests

- Test Coverage with JaCoco and SonarQube


###6. Future improvements :  
- Code improvements 1 : Reducing Java Boilerplate with Lombok dependencies + plugin

- Code improvements 2 : Improve Mapping by defining generic mapper and take advantage from MapStruc





