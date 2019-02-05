# 'CRAZYAIR-SERVICE' Springboot Microservice 
.

###1. configuration 

Run Eureka Naming Server 

	java -jar eureka-naming-server.jar

For Eureka Server console open browser and go to http://localhost:8761


###2. Run

Navigate to Executable folder and run it
 
	cd crazyair/target
	
	java -jar crazyair.jar  (Default port 8020 specified in properties file)
	
For running more instances do specify a different port 

	java  -jar crazyair.jar   --port=<PORT>
 
###3. Test Rest Services (required JSON RequestBody available in src/main/in)
* 3.1) In a rest client specify the headers 
	Content-Type=[{"key":"Content-Type","name":"Content-Type","value":"text/plain","description":"","type":"text"}] 
	
* 3.2) invoke the following rest service 


Example 1 - retrieve all solution for flight :

			PUT http://localhost:8020/api/toughjet
			
			{ "origin":"WAW",
			  "destination":"WRO",
			  "departureDate":"2018-12-28T12:00:00+01:00",
			  "returnDate":"2019-01-01T14:00:00+01:00",
			  "passengerCount":2
			}
			
		




