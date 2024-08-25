FROM maven:3.9-eclipse-temurin-17-alpine

#set workdir
WORKDIR /home/app

#copy source
COPY src ./src

#copy dependecies and install it
COPY pom.xml .

COPY target/project-api-0.0.1-SNAPSHOT.jar target.jar

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "target.jar"]
