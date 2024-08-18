# How to run

This is a Spring Boot application built with Java. Follow the instructions below to set up and run the application locally without Docker.

## Prerequisites

Make sure you have the following installed:

1. **Java 17** (or newer)
2. **Maven** (for building the project)

## Setting Up

### 1. Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/jamaludinahmad/backend-project-management.git
cd backend-project-management
```

## 2. Configuration
Ensure that your application properties are correctly configured. By default, the configuration is located in src/main/resources/application.properties.

Make sure the database settings are correctly set, e.g.:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/proyek <- (you can edit with your own name)
spring.datasource.username=root <- (you can edit with your own username)
spring.datasource.password=your_password <- (you can edit with your own password) 

server.port=9000 <- (you can edit with your own port)

```

## 3. Set Up MySql
   Create your own database name


## 4. Running the project
### 4.1 run with spring boot 
```bash
mvn spring-boot:run
```

### 4.2 run jar package 
#### Build the package
```bash
mvn clean install
```
#### run the package
``` bash
java -jar target/your-app-name-0.0.1-SNAPSHOT.jar

```