FROM openjdk:8-jdk-alpine
MAINTAINER neel
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]