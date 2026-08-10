# 🛒 Order Management API

A REST API for managing orders and payments, built with **Java + Spring Boot** and structured using **Hexagonal Architecture (Ports and Adapters)**.

The project is designed to apply, in practice, important backend development concepts such as software architecture, relational databases, messaging, concurrency, and system reliability.

## 🚀 Features

### 📦 Order Management

* Create orders
* Retrieve orders by ID
* List orders
* Add products to orders
* Update order status
* Validate order-related business rules

### 💳 Payments

* Process payments
* Ensure **idempotency** using `Idempotency-Key`
* Prevent duplicate processing of the same operation
* Simulate communication with an external payment service
* Apply a **Circuit Breaker** to external service failures

### 📊 Inventory

* Track available inventory
* Validate stock availability when creating orders
* Handle concurrent operations
* Maintain consistency through database transactions

### 📨 Messaging

* Publish order-related events
* Process asynchronous operations using RabbitMQ
* Handle duplicate messages
* Build consumers prepared for **at-least-once delivery**

### 🔐 Authentication and Authorization

* Authentication using Spring Security
* Protected endpoints
* Permission-based access control

---

## 🏗️ Architecture

The project follows **Hexagonal Architecture**, separating the domain from infrastructure and external implementation details.

```text
                    ┌──────────────────┐
                    │    REST API      │
                    │  Input Adapter   │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │      PORT        │
                    │    Use Cases     │
                    └────────┬─────────┘
                             │
                             ▼
                    ┌──────────────────┐
                    │     DOMAIN       │
                    │                  │
                    │ Orders           │
                    │ Payments         │
                    │ Business Rules   │
                    └────────┬─────────┘
                             │
                  ┌──────────┴──────────┐
                  ▼                     ▼
          ┌──────────────┐      ┌──────────────┐
          │  PostgreSQL  │      │   RabbitMQ   │
          │ Output       │      │ Output       │
          │ Adapter      │      │ Adapter      │
          └──────────────┘      └──────────────┘
```

The domain does not directly depend on frameworks, databases, or external services.

Dependencies are directed toward the domain through **Ports**, while external details are implemented through **Adapters**.

---

## 🧠 Concepts Applied

The project is designed to practice concepts such as:

### Object-Oriented Programming

* Encapsulation
* Abstraction
* Inheritance
* Polymorphism
* Interfaces
* Composition
* Immutability

### SOLID

* Single Responsibility Principle
* Open/Closed Principle
* Liskov Substitution Principle
* Interface Segregation Principle
* Dependency Inversion Principle

### Architecture

* Hexagonal Architecture
* Ports and Adapters
* Separation of concerns
* Low coupling
* High cohesion
* Dependency inversion

### Database

* Relational data modeling
* Primary and foreign keys
* Relationships
* Indexes
* JOINs
* Transactions
* ACID
* Transaction isolation
* Concurrency

### Reliability

* Idempotency
* Idempotency Keys
* Race conditions
* At-least-once delivery
* At-most-once delivery
* Circuit Breaker

### Networking and Communication

* HTTP/REST
* HTTPS/TLS
* DNS
* TCP/IP
* Ports
* Reverse Proxy

---

## 🛠️ Technologies

* **Java**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA**
* **Hibernate**
* **PostgreSQL**
* **RabbitMQ**
* **Docker**
* **Lombok**
* **JUnit**
* **Mockito**

---

## 📌 Example Endpoints

### Create Order

```http
POST /orders
Content-Type: application/json
Authorization: Bearer <token>
```

### Get Order

```http
GET /orders/{id}
Authorization: Bearer <token>
```

### Process Payment

```http
POST /orders/{id}/payment
Idempotency-Key: 550e8400-e29b-41d4-a716-446655440000
Authorization: Bearer <token>
```

The `Idempotency-Key` ensures that the same operation is not processed multiple times if the request is retried.

---

## 🗄️ Database

The system uses **PostgreSQL** as its relational database.

Operations that require consistency across multiple changes are executed within database transactions.

Conceptual example:

```text
Create Order
     ↓
Add Items
     ↓
Reserve Inventory
     ↓
Commit Transaction
```

If a critical operation fails:

```text
ROLLBACK
```

prevents the database from being left in an inconsistent state.

---

## 📨 Messaging Flow

Some operations can be processed asynchronously:

```text
Order Created
      ↓
Event Published
      ↓
RabbitMQ
      ↓
Consumer
      ↓
Processing
```

Consumers are designed to handle potential duplicate messages and keep operations idempotent when necessary.

---

## 🧪 Testing

The project includes tests for:

* Business rules
* Use cases
* Controllers
* Database integration
* Message processing
* Idempotency
* Concurrency scenarios

---

## 🎯 Project Goals

This project was created as a practical application of concepts commonly used in modern backend systems.

The goal is not only to implement features, but also to understand **why certain architectural decisions exist and which problems they solve**.

Key objectives include:

* Practice Hexagonal Architecture
* Apply SOLID principles
* Work with relational databases
* Understand transactions and concurrency
* Implement idempotency
* Work with asynchronous messaging
* Build REST APIs
* Apply resilience patterns
* Write automated tests
* Integrate multiple components using Docker

---

## 📚 Status

🚧 **In Development**

The project will be developed incrementally, with new features and concepts being added throughout the development process.

