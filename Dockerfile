# Stage 1: Build the application
FROM openjdk:17-jdk-alpine as builder

WORKDIR /app

COPY pom.xml ./
COPY .mvn/ .mvn/
COPY mvnw ./
COPY src/ ./src/

RUN ./mvnw package -DskipTests

# Stage 2: Copy the jar file from the builder stage to the final stage
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
