# Order Processing System

## Tech Stack
- Java 17
- Spring Boot
- PostgreSQL
- JPA/Hibernate
- Lombok

## Features
- Create Order
- Get Order
- List Orders (filter by status)
- Cancel Order (only PENDING)
- Auto-process orders every 5 mins

## Setup

1. Create DB:
   CREATE DATABASE order_db;

2. Update application.yml:
   username & password

3. Run:
   mvn spring-boot:run

## APIs
POST /orders  
GET /orders/{id}  
GET /orders?status=PENDING  
PUT /orders/{id}/cancel  

## Scheduler
Automatically moves PENDING → PROCESSING every 5 minutes.

## AI Usage
Used ChatGPT for:
- Project structure
- Code optimization
- Scheduler implementation

Refined manually:
- DB relationships
- Business rules
