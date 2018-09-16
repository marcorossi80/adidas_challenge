# adidas-challenge

This is the response to the Adidas Coding Challenge developed by Rafael Banzo.

## Comments about the implementation

There are three projects in this git repository:

### city-connection-manager
This microservice that maintains the details of the city connections.
All the data is stored in an h2 in-memory data base.
By default, it runs in http://localhost:8082
It includes two contollers:
* connection-instance-controller: This controller maintains the connections between two cities that have been done on a specific day and time.
It has five methods:
** /connection-instance/ POST --> Inserts a connection between two cities that has been done on a specific date and time.
If it is sucessful, it returns http status 201 and the id with which it has been stored in the data base.
** /connection-instance/{id} GET --> Reads a connection between two cities that has been done on a specific date and time.
** /connection-instance/{id} PUT --> Updates a connection between two cities that has been done on a specific date and time.
** /connection-instance/{id} DELETE --> Deletes a connection between two cities that has been done on a specific date and time.
** /connection-instance/ GET --> List all the connections between any two cities that has been done on a any date and time.
* connection-controller This service return a list of all the connections between any two cities stored in the data base with their mean duration.
** /connection/ GET --> lIST all the connections between any two cities stored in the data base with their mean duration.

For more detailed documentation, when the microservice is running, the swagger documentation can be found in this URL
http://localhost:8082/swagger-ui.html#

### distance-calculator
This microservice calculates the shortest route between two cities both in time and in number of connections.
By default, it runs in http://localhost:8082
It has only one controller with one method:
* /distance-calculator-controller
** /calculate-shortest/{city}/{destiny-city}?calculation-mode=[TIME|CONNECTIONS] GET--> Calculates the shortest journey
(in time and in connections) to travel from one city to another.
The list of connections is obtained from city-connection-manager using a feign client.

For more detailed documentation, when the microservice is running, the swagger documentation can be found in this URL
https://localhost:8083/swagger-ui.html

### eureka
This is an implementation of eureka programmed using spring boot.
It facilitates the connection from distance-calculator to city-connection-manager

## Frameworks and libraries
### Spring boot.
I have used it because it was mention as the ideal election for the challange.
Besides, spring boot allows the creation of stand-alone applications, it has en embedded Tomcat,
it follows the paradigm convention over configuration with makes easier and faster the implementation
and it still possible to change its defaults easily.
### spring-cloud-starter
I have used it because it includes all the needed dependencies to develop of spring-cloud including
service discovery (eureka), feign clients and circuit breakers (hystrix).
### spring-boot-starter-web
I have used it in order to build easily, using annotations, the REST controllers.
### spring-cloud-starter-netflix-eureka-client
I have used it because I was getting errors when registering in Eureka and I found out that
using this dependency solved the problem.
### spring-boot-starter-data-jpa
I have used it because it makes easy to access JPA based repositories.
### com.h2database:h2
I have used an h2 in-memory database because it does not need any external program.
### springfox-swagger
I have used it to document the REST API.
### springfox-swagger-ui
I have used it because it provides a very visual representation of the REST API.
It also allowed me to make request easily.
Any way, in order to test the REST API, I have used Postman.
### lombok
I have used it because with lombok, it is not necessary to write so much boiler-plate code specially getters, setters
and builders.
### spring-boot-starter-test
I have used it because it can be used to bootstrap all the spring container when running the tests.
### spring-boot-gradle-plugin and gradle-docker
I have used it to build the docker image


## Running the application
### Prerequisites

For the method 1, it is necessary to have java, git and gradle configured in the machine.
For the method 2, it is necessary to have docker.

### Installing

Download the code First clone the git repository from **https://github.com/rafabanzo/adidas_challenge/**
Method 1
* Go to the directory eureka, build the jar and run tests **gradle build**
* Run the application using run.sh or run.bat
* Go to the directory city-connection-manager, build the jar and run tests **gradle build**
* Run the application using run.sh or run.bat
* Go to the directory distance-calculator, build the jar and run tests **gradle build**
* Run the application using run.sh or run.bat

NOTE: Once all the services are running, the postman collection **challenge.postman_collection.json** can be run 
to assure the correct functional end-to-end behaviour. 

Method 2
* Go to the directory eureka build the docker image **gradlew docker build**
* Run **docker run -p 8761:8761 -t com.adidas.challenge/eureka
* Go to the directory city-connection-manager build the docker image **gradlew docker build**
* Run **docker run -p 8082:8082 -t com.adidas.challenge/city-connection-manager
* Go to the directory distance-calculator build the docker image **gradlew docker build**
* Run **docker run -p 8083:8083 -t com.adidas.challenge/distance-calculator**
NOTE: I have not been able to run the method 2 as I have had problems installing docker on my old windows 7 laptop


