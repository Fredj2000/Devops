FROM openjdk:8-jre-alpine
EXPOSE 8999
ADD target/DevOps_Project-1.0.jar DevOps_Project.jar
ENTRYPOINT["java","-jar","DevOps_Project.jar"]