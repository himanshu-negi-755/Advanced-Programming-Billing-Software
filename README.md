# Billing System API

A Spring Boot REST API for managing billing, orders, and inventory with JWT authentication and role-based access control.

## Features

- User authentication & authorization (JWT)
- Category and item management with image uploads
- Order processing and tracking
- Razorpay payment integration
- Dashboard analytics (sales, order count)
- Role-based access (ADMIN/USER)

## Architecture

4-layer architecture:
- **Presentation**: REST controllers
- **Business**: Service classes
- **Persistence**: JPA repositories
- **Security**: JWT & Spring Security

## Database Schema

| Entity | Key Fields |
|--------|-----------|
| User | id, email, password, role |
| Category | id, name, imageUrl |
| Item | id, name, price, category_id |
| Order | id, userId, totalAmount, paymentStatus |
| OrderItem | id, orderId, itemId, quantity |

**Key Relationships**: Category ↔ Items (1:N), Order ↔ OrderItems (1:N)

## Installation

```bash
# Clone repository
git clone https://github.com/yourusername/billing-system-api.git
cd billing-system-api

# Configure MySQL database in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/billing_db
spring.datasource.username=root

# Build and run
mvn clean install
mvn spring-boot:run
```

Server runs on `http://localhost:8080`

## API Endpoints

| Method | Endpoint | Auth | Role |
|--------|----------|------|------|
| POST | /login | ✗ | - |
| POST | /admin/register | ✓ | ADMIN |
| GET | /categories | ✓ | USER |
| POST | /admin/categories | ✓ | ADMIN |
| GET | /items | ✓ | USER |
| POST | /orders | ✓ | USER |
| GET | /orders | ✓ | USER |
| POST | /payments/create-order | ✓ | USER |
| GET | /dashboard | ✓ | ADMIN |

## Authentication

JWT-based authentication:
```bash
curl -X GET http://localhost:8080/orders \
  -H "Authorization: Bearer <jwt_token>"
```

## Limitations & Future Work

**Current Limitations**:
- No update operations (incomplete CRUD)
- Payment verification not fully implemented
- Basic error handling (needs global exception handler)
- Local file storage only

**Future Improvements**:
- Add PUT/PATCH endpoints for all entities
- Implement complete Razorpay verification
- Global exception handler with @ControllerAdvice
- AWS S3 integration for file storage
- Unit and integration tests

