FROM maven:3.8.3-jdk-11 AS build
COPY . /app
WORKDIR /app
RUN mvn clean install -DskipTests

# Second stage: create a slim image
FROM openjdk:11-jre-slim
COPY --from=build /app/target/simple-crm-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]