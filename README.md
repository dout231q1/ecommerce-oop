# ecommerce-oop
> Evolution of the [v1-oop](https://github.com/dout231q1/ecommerce-oop/tree/v1-oop) project.
> Rewriting the same e-commerce system from scratch using Spring Boot, JPA and PostgreSQL.

## v4 — Cart

Everything from v3, now with a cart system. Each user gets their own cart — if one doesn't exist yet, it's created automatically on the first request.

The cart holds a list of products through a many-to-many relationship. No quantities, no order — just a clean list of what the user picked.

This version also introduces proper error handling. Invalid user or product IDs throw a `ResourceNotFoundException` instead of crashing, and unmatched routes return a proper response instead of a blank 404.

## Endpoints

### Cart
```http
GET    /cart/{userId}
POST   /cart/{userId}/product/{productId}/add
DELETE /cart/{userId}/product/{productId}/remove
GET    /cart/{userId}/total
```

### Products & Users (from v3)
```http
GET    /products
POST   /products
PUT    /products/{id}
DELETE /products/{id}

GET  /user/{id}
POST /user
```

## How to Run
```bash
git clone https://github.com/dout231q1/ecommerce-oop
cd ecommerce-oop
git checkout v4-spring/cart
# create the database, configure application.properties, then:
./mvnw spring-boot:run
```

## Requirements
- JDK 17+
- PostgreSQL

## Project Evolution
| Branch | Description |
|--------|-------------|
| [v1-oop](https://github.com/dout231q1/ecommerce-oop/tree/v1-oop) | Pure Java OOP |
| [v2-spring/user](https://github.com/dout231q1/ecommerce-oop/tree/v2-spring/user) | Spring Boot — User module |
| [v3-spring/product](https://github.com/dout231q1/ecommerce-oop/tree/v3-spring/product) | Spring Boot — Product module |
| [v4-spring/cart](https://github.com/dout231q1/ecommerce-oop/tree/v4-spring/cart) | Spring Boot — Cart module |
| v5-spring/order | Spring Boot — Order + Checkout |
