# Comcast - FreeWheel Project


## Prerequisites for building and deploying application locally
### Software requirements
1. Eclipse - To run application
2. Postman - Tool for testing the HTTP request
3. PostgreSQL - Database for User 

### Packages required
1. Spring Boot
2. Hibernate
3. Bootstrap
4. Jquery

## Build and Deploy instructions for web application (Questions 1 and 3)
 1. Open **freewheel** in Eclipse
 2. Open **FreewheelApplictaion** file and run as Java application
 3. Open Postman and test the below mentioned end-points
  
  **End-points**
	 
 - GET http://localhost:8080/freewheel/programs
	 - Get success response as list of programs from Program table.
 - Get http://localhost:8080/freewheel/cartesian
	 - Insert the number of missing market pops to market_pop table

## User interface (Question 2)
 

 1. Run http://localhost:8080 in browser to get the index.html displaying list of stations
 2. Select any row to get it's earliest flight date
  **End-points**
  
 - GET http://localhost:8080/freewheel/stations
	 - Get success response as list of stations from station table.
 - GET http://localhost:8080/freewheel/programbystationid/{stationId}
	 - Get earliest flight date by station id

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.4/maven-plugin/reference/html/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.4/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

