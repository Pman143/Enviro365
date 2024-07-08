
# Enviro365 Project

## Overview

Enviro365 is a Spring Boot-based project that includes user authentication, authorization, and organization management. The project uses JWT for authentication and provides access control to organization details.

## Technologies Used

- Spring Boot 3.3.1
- Spring Security 6
- JWT
- Spring Data JPA
- H2 Database (for development)
- Spring Cloud Config Server
- MapStruct
- OpenAPI (Swagger)

## Setup Instructions

### Prerequisites

- JDK 17 or higher
- Maven
- Git

### Clone the Repository

```bash
git clone https://github.com/Pman143/Enviro365
cd enviro365
```

### Configuration

Ensure your configuration repository is set up on GitHub and has the necessary configuration files (`application.yml`, etc.).

#### Application Configuration

Update your application's `bootstrap.yml` to point to the config server:

```yaml
spring:
  application:
    name: enviro365
  cloud:
    config:
      uri: http://localhost:8888
```

### Running the Application

1. **Start the Config Server**:
    ```bash
    cd config-server
    mvn spring-boot:run
    ```

2. **Start the Enviro365 Application**:
    ```bash
    cd ../enviro365
    mvn spring-boot:run
    ```

### API Endpoints

- **Auth Endpoints**:
    - `POST /api/v1/auth/register`: Register a new user.
    - `POST /api/v1/auth/login`: Authenticate a user and obtain a JWT.

- **Organization Endpoints**:
    - `GET /api/v1/organizations/{organizationId}`: Get organization details (secured).

### Testing with Swagger

1. Access Swagger UI at `http://localhost:8080/swagger-ui.html`.
2. Use the `Authorize` button to provide the JWT token for secured endpoints.

### Additional Information

- **MapStruct**: Used for mapping DTOs to entities.
- **H2 Database**: In-memory database for development and testing purposes.
- **JWT**: Used for securing the application.
