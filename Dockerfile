FROM maven:3.9.6-eclipse-temurin-17 AS build
ENV PORT=8081
COPY . /app
WORKDIR /app
RUN mvn clean install -DskipTests

# Second stage: create a slim image
FROM eclipse-temurin:17
ENV PORT=8081
COPY --from=build /app/target/simple-crm-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]