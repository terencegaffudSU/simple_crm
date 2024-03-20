FROM maven:3.8.4-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests
COPY target/*.jar app.jar

FROM eclipse-temurin:17-jdk-alpine
ENTRYPOINT ["java","-jar","/app.jar"]