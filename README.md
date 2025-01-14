# Shopping List Manager

A microservices-based shopping list management application using Spring Boot and Angular.

## Project Structure

- `frontend/` - Angular web application
- `gateway/` - API Gateway service
- `product-service/` - Product management microservice
- `shopping-list-service/` - Shopping list management microservice  
- `user-service/` - User management microservice

## Prerequisites

- Java 17 or higher
- Maven
- Docker and Docker Compose
- Node.js and npm

## Setup and Installation

1. Generate Maven Wrapper (if not present):
```bash
mvn wrapper:wrapper
```
2. Build service
```bash
./mvnw clean package -DskipTests
```
3. Run the application stack:
```bash
sudo docker compose up --build
```

## TODO
Make correct gateway in docker compose and other services (dute to laboratory tasks it is done how its done)