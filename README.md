# CRUD Operations Example

A Spring Boot REST API application demonstrating basic CRUD (Create, Read, Update, Delete) operations for managing products. This project serves as a practical example of building a RESTful web service using Spring Boot, Spring Data JPA, and H2 in-memory database.

## 📋 Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Usage Examples](#usage-examples)
- [Configuration](#configuration)
- [Database Access](#database-access)
- [Project Architecture](#project-architecture)
- [Contributing](#contributing)

## ✨ Features

- **Create Products**: Add new products to the system
- **Read Products**: Retrieve all products or a specific product by ID
- **Update Products**: Modify existing product information
- **Delete Products**: Remove products from the system
- **In-Memory Database**: Uses H2 database for easy setup and testing
- **RESTful API**: Follows REST principles for clean API design

## 🛠 Technology Stack

- **Java**: 17
- **Spring Boot**: 3.5.7
- **Spring Web**: For building RESTful web services
- **Spring Data JPA**: For database operations and repository abstraction
- **H2 Database**: In-memory database for development and testing
- **Maven**: Build automation and dependency management

## 📁 Project Structure

```
curd-operations-example/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── Main.java                 # Spring Boot application entry point
│   │   │           ├── controller/
│   │   │           │   └── ProductController.java # REST controller for product endpoints
│   │   │           ├── entity/
│   │   │           │   └── Product.java          # Product entity class
│   │   │           ├── repository/
│   │   │           │   └── ProductRepository.java # JPA repository interface
│   │   │           └── service/
│   │   │               └── ProductService.java   # Business logic layer
│   │   └── resources/
│   │       └── application.properties            # Application configuration
│   └── test/
│       └── java/                                  # Test files (to be implemented)
├── pom.xml                                        # Maven project configuration
└── README.md                                      # Project documentation
```

## 📦 Prerequisites

Before you begin, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 17 or higher
- **Maven**: Version 3.6.0 or higher
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code (optional but recommended)

### Verify Installation

```bash
java -version    # Should show Java 17 or higher
mvn -version     # Should show Maven 3.6.0 or higher
```

## 🚀 Installation & Setup

1. **Clone the repository** (if applicable) or navigate to the project directory:
   ```bash
   cd curd-operations-example
   ```

2. **Build the project** using Maven:
   ```bash
   mvn clean install
   ```

3. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

   Alternatively, you can run the `Main.java` class directly from your IDE.

4. **Verify the application is running**:
   - The application should start on `http://localhost:8080` (default Spring Boot port)
   - You should see Spring Boot startup logs in the console

## 🏃 Running the Application

### Using Maven

```bash
mvn spring-boot:run
```

### Using IDE

1. Open the project in your IDE (IntelliJ IDEA, Eclipse, etc.)
2. Locate `Main.java` in `src/main/java/org/example/`
3. Right-click and select "Run Main.main()"

### Using JAR file

After building the project:

```bash
java -jar target/curd-operations-example-1.0-SNAPSHOT.jar
```

## 🔌 API Endpoints

The application provides the following REST endpoints:

| Method | Endpoint | Description | Request Body |
|--------|----------|-------------|--------------|
| `POST` | `/products` | Create a new product | `{ "name": "string", "price": number }` |
| `GET` | `/products` | Get all products | - |
| `GET` | `/products/{id}` | Get product by ID | - |
| `PUT` | `/products/{id}` | Update product by ID | `{ "name": "string", "price": number }` |
| `DELETE` | `/products/{id}` | Delete product by ID | - |

### Base URL

```
http://localhost:8080
```

## 💡 Usage Examples

### 1. Create a Product

**Request:**
```bash
curl -X POST http://localhost:8080/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Laptop",
    "price": 999.99
  }'
```

**Response:**
- Status: `200 OK`
- No response body

### 2. Get All Products

**Request:**
```bash
curl -X GET http://localhost:8080/products
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 999.99
  },
  {
    "id": 2,
    "name": "Mouse",
    "price": 29.99
  }
]
```

### 3. Get Product by ID

**Request:**
```bash
curl -X GET http://localhost:8080/products/1
```

**Response:**
```json
{
  "id": 1,
  "name": "Laptop",
  "price": 999.99
}
```

### 4. Update a Product

**Request:**
```bash
curl -X PUT http://localhost:8080/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Gaming Laptop",
    "price": 1299.99
  }'
```

**Response:**
- Status: `200 OK`
- No response body

### 5. Delete a Product

**Request:**
```bash
curl -X DELETE http://localhost:8080/products/1
```

**Response:**
- Status: `200 OK`
- No response body

### Using Postman or Similar Tools

1. **Create Product**: 
   - Method: `POST`
   - URL: `http://localhost:8080/products`
   - Headers: `Content-Type: application/json`
   - Body (raw JSON):
     ```json
     {
       "name": "Keyboard",
       "price": 79.99
     }
     ```

2. **Get All Products**:
   - Method: `GET`
   - URL: `http://localhost:8080/products`

3. **Get Product by ID**:
   - Method: `GET`
   - URL: `http://localhost:8080/products/1`

4. **Update Product**:
   - Method: `PUT`
   - URL: `http://localhost:8080/products/1`
   - Headers: `Content-Type: application/json`
   - Body (raw JSON):
     ```json
     {
       "name": "Mechanical Keyboard",
       "price": 99.99
     }
     ```

5. **Delete Product**:
   - Method: `DELETE`
   - URL: `http://localhost:8080/products/1`

## ⚙️ Configuration

The application configuration is located in `src/main/resources/application.properties`:

```properties
# H2 Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver

# JPA/Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update

# H2 Console (for database access)
spring.h2.console.enabled=true
```

### Configuration Options

- **`spring.datasource.url`**: H2 in-memory database URL
- **`spring.jpa.hibernate.ddl-auto=update`**: Automatically creates/updates database schema
- **`spring.h2.console.enabled=true`**: Enables H2 web console for database inspection

### Changing the Server Port

To change the default port (8080), add the following to `application.properties`:

```properties
server.port=9090
```

## 🗄️ Database Access

The H2 console is enabled for database inspection and querying.

1. **Access H2 Console**:
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa` (default)
   - Password: (leave empty)

2. **View Products Table**:
   ```sql
   SELECT * FROM PRODUCT;
   ```

**Note**: Since H2 is an in-memory database, all data will be lost when the application stops.

## 🏗️ Project Architecture

This project follows a layered architecture pattern:

```
┌─────────────────┐
│   Controller    │  ← REST API endpoints
│  (ProductController)
└────────┬────────┘
         │
┌────────▼────────┐
│    Service      │  ← Business logic
│ (ProductService)
└────────┬────────┘
         │
┌────────▼────────┐
│   Repository    │  ← Data access layer
│(ProductRepository)
└────────┬────────┘
         │
┌────────▼────────┐
│     Entity      │  ← Data model
│    (Product)
└─────────────────┘
```

### Layer Responsibilities

- **Controller Layer**: Handles HTTP requests and responses, maps URLs to service methods
- **Service Layer**: Contains business logic and orchestrates data operations
- **Repository Layer**: Provides data access abstraction using Spring Data JPA
- **Entity Layer**: Defines the data model and database mapping

## 📝 Product Entity

The `Product` entity contains the following fields:

- **`id`** (Long): Primary key, auto-generated
- **`name`** (String): Product name
- **`price`** (double): Product price

## 🔍 Error Handling

Currently, the application returns `null` when a product is not found. Consider implementing proper error handling with appropriate HTTP status codes (e.g., `404 Not Found`) for production use.

## 🧪 Testing

To test the API endpoints, you can use:

- **cURL**: Command-line tool (examples provided above)
- **Postman**: GUI tool for API testing
- **HTTPie**: Modern command-line HTTP client
- **Browser**: For GET requests only

### Example Test Flow

1. Create a product
2. Retrieve all products (verify the created product appears)
3. Retrieve the product by ID
4. Update the product
5. Verify the update
6. Delete the product
7. Verify deletion (product should not appear in the list)

## 🚧 Future Enhancements

Potential improvements for this project:

- [ ] Add input validation
- [ ] Implement proper error handling with custom exceptions
- [ ] Add unit and integration tests
- [ ] Add API documentation with Swagger/OpenAPI
- [ ] Implement pagination for GET all products
- [ ] Add search/filter functionality
- [ ] Switch to a persistent database (PostgreSQL, MySQL)
- [ ] Add authentication and authorization
- [ ] Implement logging
- [ ] Add request/response DTOs

## 📄 License

This project is provided as an example for educational purposes.

## 🤝 Contributing

Contributions are welcome! If you'd like to contribute:

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## 📞 Support

For questions or issues, please open an issue in the repository.

---

**Happy Coding! 🎉**

