# Pós Tech FIAP - Tech Challenge

## Architecture and Java Development

### WeFood - Restaurant Management System

---

## Overview

The **Tech Challenge** is a hands-on project from FIAP’s postgraduate course in Java Architecture and Development, aiming to create a restaurant management system, developed in phases.

> **Main goal:**
> Allow multiple restaurants to use a single, efficient system, reducing costs and offering a great experience for restaurants and customers alike.

---

## Phase 1 Objective

Develop a robust and complete backend using **Spring Boot**, focused on user management. The implemented operations include:

- User creation
- User data updating
- User deletion
- Login validation

The project is Docker-ready, uses Docker Compose for orchestration, and is integrated with a relational database (PostgreSQL or H2).

---

## Features

### User Management

- **Registration fields:**
    - Name (`String`)
    - Email (`String`)
    - Username (`String`)
    - Password (`String`)
    - Last update date (`Date`)
    - Address

- **Password change**: Users can change their password.
- **Login validation**: Checks user credentials.
- **User deletion**: Remove registered users.

### User Roles

- Restaurant Owner
- Customer
- Admin

---

## Architecture

The backend is developed in **Spring Boot**, follows **SOLID** principles, and uses **Hexagonal Architecture** and **Clean Architecture**.
*Business rules are isolated from external dependencies.*

### Modular Design

> Communication between modules is done via interfaces, so each module can be developed and tested independently.

#### Key Modules

- **config:**
    - `SwaggerConfig`, `AdminUserInitializer`
- **controller:**
    - `AuthController` (`POST /login` - JWT issuance)
    - `UserController` (`GET`, `POST`, `PUT`, `DELETE` endpoints for user management, each with access control)
- **domain/model:**
    - `User`, `Id`, `Name`, `Email`, `Username`, `Password`, `Role`, `Address`
- **dto:**
    - `UserDtoRequest`, `UserDtoResponse`
- **exception:**
    - `ApiError`, `GlobalExceptionHandler`, `UserAlreadyExistsException`, `UserNotFoundException`
- **mapper:**
    - `UserMapper`
- **repository/user:**
    - `UserEntity`, `UserRepositoryImpl`, `JpaUserEntityRepository`
- **security:**
    - `JwtAuthenticationFilter`, `JwtUtil`, `MyUserDetails`, `MyUserDetailsService`, `SecurityConfig`, `SecurityExceptionHandlerConfig`, `SecurityUtil`
- **service:**
    - `UserService`

---

## 🛠️ Technology Stack

- **Java 21**
- **Spring Boot** (core app)
- **Spring Data JPA** (data access)
- **Spring Security** (auth/authz)
- **H2** / **PostgreSQL** (databases)
- **Docker** / **Docker Compose**
- **MapStruct** (object mapping)
- **Swagger** (API docs)
- **Mockito** (mocking)
- **JUnit 5** (tests)
- **Postman** (manual API testing)

---

## 🔧 Configurations

- **Default Admin User:**
    - `login`: `admin`
    - `password`: Value from `admin.password` in `application.properties`

- **JWT Secret:**
    - Value from `jwt.secret` in `application.properties`

- **Database:**
  - Env`SPRING_PROFILES_ACTIVE=postgres` to use PostgreSQL
  - Env`SPRING_PROFILES_ACTIVE=h2` to use in memory H2
---

## 🚀 Running the Project

### 1. Clone the Repository

```bash
git clone https://github.com/dpcamargo/fiap-wefood.git
```

### 2. Go to the Project Directory

```bash
cd wefood
```

### 3. Start using H2

```bash
docker-compose -f docker-compose-h2.yaml up -d
```

---

## 📁 Project Structure

```plaintext
src
 ├── main
 │  ├── java
 │  │  └── br
 │  │      └── com
 │  │          └── fiap
 │  │              └── wefood
 │  │                  ├── WefoodApplication.java
 │  │                  ├── config
 │  │                  ├── controller
 │  │                  ├── domain
 │  │                  │  └── model
 │  │                  ├── dto
 │  │                  ├── exception
 │  │                  ├── mapper
 │  │                  ├── repository
 │  │                  │  └── user
 │  │                  ├── security
 │  │                  └── service
 │  ├── resources
 │  │   └── application.properties
 │  └── docs
 ├── Dockerfile
 ├── docker-compose.yml
```

---

## Endpoints

- Postman collection: `/postman/wefood.json`
- Application: [http://localhost:8080](http://localhost:8080)
- Swagger UI: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- OpenAPI Docs: [http://localhost:8080/api-docs](http://localhost:8080/api-docs)

### User Controller

#### GET /users

*   **Summary:** Get all users. Administrators only.
*   **Description:** Returns a list of all users.
*   **Operation ID:** `getUsers`
*   **Tags:** `user-controller`
*   **Responses:**
    *   `200 OK`: Users retrieved successfully. Returns an array of `UserDtoResponse` objects.

#### PUT /users

*   **Summary:** Update user content. Only admin can change other users. User can change itself, except for role.
*   **Description:** Updates user data.
*   **Operation ID:** `updateUser`
*   **Tags:** `user-controller`
*   **Request Body:** `application/json` with schema `UserDtoRequest`
*   **Responses:**
    *   `200 OK`: User updated successfully. Returns a `UserDtoResponse` object.

#### POST /users

*   **Summary:** Create a new user. Can only create CUSTOMER role. Admin can create any role.
*   **Description:** Creates a new user.
*   **Operation ID:** `createUser`
*   **Tags:** `user-controller`
*   **Request Body:** `application/json` with schema `UserDtoRequest`
*   **Responses:**
    *   `201 Created`: User created successfully. Returns a `UserDtoResponse` object.

#### GET /users/{user_id}

*   **Summary:** Get user by ID. User can only get it's own data. Admin can get any user.
*   **Description:** Returns a user by their ID.
*   **Operation ID:** `getUser`
*   **Tags:** `user-controller`
*   **Parameters:**
    *   `user_id` (path, required): Integer (int64)
*   **Responses:**
    *   `200 OK`: User retrieved successfully. Returns a `UserDtoResponse` object.

#### DELETE /users/{user_id}

*   **Summary:** Excludes an user. Only admin can exclude other users. User can exclude itself.
*   **Description:** Excludes an user.
*   **Operation ID:** `deleteUser`
*   **Tags:** `user-controller`
*   **Parameters:**
    *   `user_id` (path, required): Integer (int64)
*   **Responses:**
    *   `204 No Content`: User deleted successfully.

### Auth Controller

#### POST /login

*   **Summary:** Logs in an user.
*   **Operation ID:** `login`
*   **Tags:** `auth-controller`
*   **Request Body:** `application/json` with schema `LoginRequestDTO`
*   **Responses:**
    *   `200 OK`: Returns a `LoginResponse` object.

## Schemas

### UserDtoRequest

```json
{
  "type": "object",
  "properties": {
    "id": {
      "type": "integer",
      "format": "int64"
    },
    "name": {
      "type": "string"
    },
    "email": {
      "type": "string"
    },
    "username": {
      "type": "string"
    },
    "password": {
      "type": "string"
    },
    "role": {
      "type": "string"
    },
    "address": {
      "type": "string"
    }
  }
}
```
### UserDtoResponse

```json
{
  "type": "object",
  "properties": {
    "id": {
      "type": "integer",
      "format": "int64"
    },
    "name": {
      "type": "string"
    },
    "email": {
      "type": "string"
    },
    "username": {
      "type": "string"
    },
    "role": {
      "type": "string"
    },
    "address": {
      "type": "string"
    }
  }
}
```

### LoginRequestDTO
```json
{
  "type": "object",
  "properties": {
    "username": {
      "type": "string"
},
  "password": {
    "type": "string"
    }
  }
}
```

### LoginResponse

```json
{
  "type": "object",
  "properties": {
    "token": {
      "type": "string"
    },
    "username": {
      "type": "string"
    },
    "expiresAt": {
      "type": "string"
    }
  }
}
```

## 💡 TODO

### 📖 Documentation

- Document **JWT structure** (header, claims, signature).
- Provide **sequence diagrams** for major flows (registration, login, password change).

### 🧪 Testing & Quality

- Include a **code coverage badge/instructions**.
- Add **sample integration tests** (especially for authentication/user management).
