FROM maven:3.9-eclipse-temurin-21-alpine AS builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package -Pproduction

FROM eclipse-temurin:21-jre-alpine
COPY --from=builder /usr/src/app/target/vaadin-home-1.0-SNAPSHOT.jar app.jar
CMD ["java", "-jar", "app.jar"]
