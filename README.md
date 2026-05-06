# ecommerce-oop
> Evolution of the [v1-oop](https://github.com/dout231q1/ecommerce-oop/tree/v1-oop) project. Rewriting the same e-commerce system from scratch using Spring Boot, JPA and PostgreSQL.

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok
- Bean Validation (jakarta.validation)

## v4 — Cart

Everything from v3, now with a cart system. Each user gets their own cart — if one doesn't exist yet, it's created automatically on the first request.

This version also introduces proper error handling. Invalid user or product IDs throw a `ResourceNotFoundException` instead of crashing, and unmatched routes return a proper response instead of a blank 404.

## Endpoints

### Cart
```http
GET    /cart/{userId}
POST   /cart/{userId}/product/{productId}/add
DELETE /cart/{userId}/product/{productId}/remove
GET    /cart/{userId}/total
```

## How to Run

```bash
# Clone the repository and switch to this branch
git clone https://github.com/dout231q1/ecommerce-oop
cd ecommerce-oop
git checkout v4-spring/cart

# Configure your credentials in
src/main/resources/application.properties

# Run
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
