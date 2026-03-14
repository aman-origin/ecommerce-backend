# API Documentation

Base URL

    http://localhost:8080/api

All requests and responses use **JSON**.

---
**System Flow**

        User → Product → Cart → Order → Payment

---

# 1. Register User

Create a new user account.

POST /users/register

Request Body

{
"name": "Aman Kumar",
"email": "[aman@gmail.com](mailto:aman@gmail.com)",
"password": "123456"
}

Example Response

{
"id": 1,
"name": "Aman Kumar",
"email": "[aman@gmail.com](mailto:aman@gmail.com)",
"role": "CUSTOMER"
}

---

# 2. Create Product

Add a product to the catalog.

POST /products

Request Body

{
"name": "iPhone 15",
"description": "Apple smartphone",
"price": 999.99,
"stock": 10,
"categoryId": 1
}

Example Response

{
"id": 1,
"name": "iPhone 15",
"description": "Apple smartphone",
"price": 999.99,
"stock": 10,
"category": "Electronics"
}

---

# 3. Get Products

Fetch paginated list of products.

GET /products?page=0&size=10

Example Response

{
"content": [
{
"id": 1,
"name": "iPhone 15",
"description": "Apple smartphone",
"price": 999.99,
"stock": 10,
"category": "Electronics"
}
],
"totalPages": 1,
"totalElements": 1
}

---

# 4. Add Product To Cart

Add a product to a user's cart.

POST /cart/add

Request Body

{
"userId": 1,
"productId": 1,
"quantity": 2
}

Response

200 OK

---

# 5. Create Order

Convert user's cart into an order.

POST /orders

Request Body

{
"userId": 1
}

Response

200 OK

---

# 6. Make Payment

Simulate payment for an order.

POST /payments

Request Body

{
"orderId": 1,
"paymentMethod": "UPI"
}

Response

200 OK
