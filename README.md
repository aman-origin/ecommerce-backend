# E-Commerce Backend (Spring Boot)

A modular monolith e-commerce backend built using **Spring Boot**.
The system implements core commerce features including product catalog, cart management, order processing, and simulated payments.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Swagger (OpenAPI)
* Git

## Architecture

Layered architecture:

    Controller → Service → Repository → Database

Modules:

* User
* Product
* Cart
* Order
* Payment

## Features

* User registration
* Product catalog management
* Add products to cart
* Order checkout
* Simulated payment processing
* Pagination for product listing
* RESTful API design
* Swagger API documentation

## API Documentation

Swagger UI available at:

    http://localhost:8080/swagger-ui.html

## Database Tables

- users
- categories
- products
- carts
- cart_items
- orders
- order_items
- payments

## Running the Project

- **Clone repository:**

        git clone https://github.com/YOUR_USERNAME/ecommerce-backend.git

- Configure database in `application.yaml`

        spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce

- Run application:

        mvn spring-boot:run

- Server runs on:

         http://localhost:8080

## Example API Flow

1. Register user
2. Create product
3. Add product to cart
4. Place order
5. Make payment
