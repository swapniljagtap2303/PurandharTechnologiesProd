# Build stage
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jdk
WORKDIR /app

# 👉 Create cert directory
RUN mkdir -p /etc/certs

# 👉 Copy TiDB CA certificate (IMPORTANT)
COPY certs/tidb-ca.pem /etc/certs/tidb-ca.pem

# 👉 Copy application jar
COPY --from=build /app/target/*.jar app.jar

EXPOSE 9091

ENTRYPOINT ["java","-jar","app.jar"]



