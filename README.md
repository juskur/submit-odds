# Odds Offering Service as Spring Boot Server
Odds Offering Service as Spring Boot Server running on http://localhost:8080/ with swagger page to test implemented operations


## Overview  
At first the server was generated by the [swagger-codegen](https://github.com/swagger-api/swagger-codegen) project from provided tech-task-swagger.yaml file. 
JPA uses H2 in memory database.
Service implementation added.
Validation added.
JUnit test for service implementation added.

After "mvn clean install" start the server with command "java -jar target\edu-odds-0.0.1-SNAPSHOT.jar"

You can view working application by pointing browser to http://localhost:8080/ 
Click on Odds and try invoking post and get Operations
