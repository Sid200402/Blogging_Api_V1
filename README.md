
# Blogging API

![Java](https://img.shields.io/badge/Java-v20-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-v3.0.0-green)

📖 Overview
Blogging API is a RESTful API built using Spring Boot that serves as the backend for a blogging platform. The API enables users to create, read, update, and delete blog posts, manage users, categories, and comments efficiently. It's designed to be scalable, robust, and easy to integrate with any frontend application.

🚀 Features
- User Management: Register, authenticate, and manage user accounts.
- Post Management: Create, edit, delete, and view blog posts.
- Category Management: Assign posts to categories for better organization.
- Comment System: Add and manage comments for blog posts.
- Pagination and Sorting**: Efficient data retrieval with built-in pagination and sorting.
- Error Handling: Consistent and descriptive error responses.
- RESTful API Design: Following best practices for resource-based endpoints.

 🛠️ Technologies Used
- Java 20
- Spring Boot
- Spring Data JPA** with Hibernate
- MySQL (for database management)
- Maven (for dependency management)
- Post Man (for api testing)

📂 Project Structure

bloggingapp/
├── src/
│   ├── main/
│   │   ├── java/com/bloggingapp/
│   │   │   ├── controller/         # REST Controllers for handling HTTP requests
│   │   │   ├── service/            # Business Logic layer
│   │   │   ├── repository/         # Database Repositories for CRUD operations
│   │   │   ├── model/              # Entity Classes for database tables
│   │   │   ├── playLoads/          # Data Transfer Objects (DTOs) and other helper classes
│   │   │   └── exception/          # Custom exception classes and global exception handling
│   │   └── resources/
│   │       ├── application.properties  # Configuration file for the application
│   │       └── static/                  # Static files (if applicable)
├── pom.xml           # Maven Configuration file to manage dependencies
└── README.md         # Project Documentation


🌟 Getting Started

 Prerequisites
- Java 20 installed on your system
- Maven installed
- A running MySQL/SQLite database instance

 Installation
1. Clone the repository:
   
   git clone https://github.com/Sid200402/Blogging_Api_V1.git
   cd Blogging_Api_V1
   

2. Update the database configuration in `application.properties`:
   
   spring.datasource.url=jdbc:mysql://localhost:3306/blogging_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   

3. Build the project:
  
   mvn clean install
 

4. Run the application:
 
   mvn spring-boot:run
  

API Endpoints
| HTTP Method | Endpoint                | Description                  |
|-------------|-------------------------|------------------------------|
| GET         | `/posts`               | Get all blog posts           |
| POST        | `/posts`               | Create a new blog post       |
| PUT         | `/posts/{id}`          | Update a blog post by ID     |
| DELETE      | `/posts/{id}`          | Delete a blog post by ID     |
| GET         | `/users`               | Get all users                |
| POST        | `/users/register`      | Register a new user          |



🤝 Contributing
Contributions, issues, and feature requests are welcome! Feel free to fork the repository and submit a pull request.


💬 Contact
For questions or feedback, feel free to reach out:
-GitHub: [Sid200402](https://github.com/Sid200402)
-Email: siddhartha191122@gmail.com
