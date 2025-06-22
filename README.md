# 🌱 Spring Boot Modular Project

This project is a modular Spring Boot application designed for scalability and clean architecture. It is divided into multiple submodules, each with a specific responsibility, supporting maintainability, reusability, and separation of concerns.

---

## 📦 Project Structure

```bash
spring-boot-project/
├── apis.contracts/       # DTOs (Request/Response), contract validation (Jakarta)
├── client.apis/          # Public REST APIs with rate limiting, health, versioning, logging, Swagger
├── db.deployment/        # Liquibase-based deployment for Main DB and Logs DB
├── data.layer/           # JPA entities and Spring Data repositories
├── logic.layer/          # Business logic, Mapper & service layer
├── models/               # Configuration and shared models
└── pom.xml               # Parent POM
```

---

## 🔍 Module Overview

### `apis.contracts`
- Contains **request/response models** used in the API layer.
- Applies **Jakarta Bean Validation** for input validation and contract enforcement.

### `client.apis`
- Hosts **REST APIs** for client consumption.
- Key Features:
  - ✅ **Rate Limiting**
  - ❤️ **Health Checks**
  - 🔢 **API Versioning**
  - 📜 **Swagger/OpenAPI Documentation**
  - 📋 **Console & DB Logging**

### `db.deployment`
- Manages database schema migrations using **Liquibase**.
- Supports:
  - 📘 **Main Database**
  - 📕 **Logs Database**

### `data.layer`
- Contains:
  - 🔸 **JPA Entities**
  - 🗃 **Repositories** (Spring Data JPA)

### `logic.layer`
- Core **business logic**, including:
  - 🧠 Services
  - 🕹 Business Rules

### `models`
- Contains:
  - ⚙️ **Configuration Models**
  - 📦 **Shared General Models**

---

## 🚀 Getting Started

### Prerequisites
- Java 21+
- Maven 3.8+

### Build and Run

```bash
# Build the entire project
mvn clean install

# Run the application
cd client.apis
mvn spring-boot:run
```

---

## 🗃 Database Migration

Run Liquibase migrations manually if needed:

```bash
cd db.deployment
mvn liquibase:update
```


## 📖 API Documentation

Swagger UI is enabled by default:

```
http://localhost:8080/swagger-ui.html
```

You can use Postman or Swagger UI to explore and test the APIs.

---