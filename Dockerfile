FROM maven:3.8.6-jdk-11 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Second stage: create a slim image
FROM openjdk:11-jre-slim
COPY --from=build /app/target/simple-crm-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]