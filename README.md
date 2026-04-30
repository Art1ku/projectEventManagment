# Event Management System

A Spring Boot 3 REST API application for managing events, tickets, and user authentication with role-based access control.

## Tech Stack

| Component | Technology |
|-----------|------------|
| Framework | Spring Boot 3.3.5 |
| Language | Java 17 |
| Database | MySQL |
| Authentication | JWT (jjwt 0.11.5) |
| API Documentation | SpringDoc OpenAPI (Swagger) |
| Build Tool | Maven |

## Features

- **User Authentication**: Register, login, and JWT-based authentication
- **Role Management**: User roles (ADMIN, USER) with role upgrade requests
- **Event Management**: Create, read, update, delete events
- **Ticket Management**: Purchase and manage event tickets
- **API Documentation**: Interactive Swagger UI at `/swagger-ui.html`
- **OpenAPI Docs**: JSON documentation at `/v3/api-docs`

## Project Structure

```
src/main/java/com/example/demo/
├── config/              # Configuration classes
│   ├── AppConfig.java
│   └── SwaggerConfig.java
├── controller/          # REST controllers
│   ├── AuthController.java
│   ├── EventController.java
│   └── TicketController.java
├── dto/                 # Data Transfer Objects
│   ├── auth/
│   ├── event/
│   └── ticket/
├── entity/              # JPA entities
│   ├── Event.java
│   ├── Ticket.java
│   └── User.java
├── enums/               # Enumerations
│   ├── Role.java
│   └── TicketStatus.java
├── exception/           # Exception handling
├── mapper/              # Entity-DTO mappers
├── repository/          # JPA repositories
├── security/            # Security configuration
│   ├── JwtFilter.java
│   ├── JwtService.java
│   └── SecurityConfig.java
└── service/             # Business logic
    ├── AuthService.java
    ├── EventService.java
    ├── TicketService.java
    └── UserService.java
```

## Prerequisites

- Java 17 or higher
- MySQL 8.0+
- Maven 3.6+

## Configuration

Database and application settings are in `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/event_db
spring.datasource.username=root
spring.datasource.password=admin123
```

## Getting Started

### 1. Create Database

```sql
CREATE DATABASE event_db;
```

### 2. Build the Project

```bash
./mvnw clean install
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

The application will start at `http://localhost:8080`

## API Documentation

Once running, access:

- **Swagger UI**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **OpenAPI JSON**: [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)

## API Endpoints

### Authentication

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register new user |
| POST | `/api/auth/login` | Login and get JWT |

### Events

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/events` | Get all events |
| GET | `/api/events/{id}` | Get event by ID |
| POST | `/api/events` | Create event (Admin) |
| PUT | `/api/events/{id}` | Update event (Admin) |
| DELETE | `/api/events/{id}` | Delete event (Admin) |

### Tickets

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/tickets` | Get all tickets |
| GET | `/api/tickets/{id}` | Get ticket by ID |
| POST | `/api/tickets` | Purchase ticket |
| PUT | `/api/tickets/{id}` | Update ticket |
| DELETE | `/api/tickets/{id}` | Cancel ticket |

### Users

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users (Admin) |
| PUT | `/api/users/role` | Request role upgrade |

## Security

- JWT-based authentication
- Role-based authorization (ADMIN, USER)
- Password encryption via BCrypt
- Protected endpoints require valid JWT token

## Default Configuration

- Server Port: 8080
- Database: MySQL (localhost:3306/event_db)
- JPA Hibernate: auto-update schema

## License

This project is for demonstration purposes.