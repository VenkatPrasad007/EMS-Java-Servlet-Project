# Employee Management System

## Project Overview
This is a **Java-based web application** developed to practice and strengthen understanding of **Servlets, JDBC, and Java web application development**.  
The project focuses on building a **role-based web application** using core Java technologies and following the **MVC architecture**.

The application allows an **Admin** to manage employee records and an **Employee** to view their own profile.

---

## Purpose of the Project
This project was started mainly to:
- Practice **Java Servlets** and HTTP request–response handling
- Work with **JDBC** for database connectivity and SQL operations
- Understand **session management** in web applications
- Implement **role-based access control**
- Build a structured Java web application using **MVC architecture**

This project was created as a learning exercise to practice **Servlets and JDBC**.

---

## Features
- Role-based login (**Admin** and **Employee**)
- Session-based authentication
- **Admin** functionalities:
  - Add employee
  - Update employee details
  - Delete employee
  - View all employees
- **Employee** functionalities:
  - View own profile
- Secure database interaction using **JDBC prepared statements**
- Clean separation of Controller, Business Logic, and Data Access layers

---

## Tech Stack
- **Java**
- **Servlets**
- **JDBC**
- **MySQL**
- **HTML, CSS, JavaScript**
- **Apache Tomcat**

---

## Project Architecture
The application follows the **MVC (Model–View–Controller)** pattern:

- **Controller:** Servlets handle incoming HTTP requests and responses
- **Model:** Java classes and JDBC handle business logic and database operations
- **View:** JSP / HTML pages render the user interface

---

## Setup and Run Instructions

### Prerequisites
- Java JDK 8 or higher
- Apache Tomcat (8.5 or above)
- MySQL Server
- Eclipse or IntelliJ IDEA

---

### Database Setup
1. Create a MySQL database named `employee_db`
2. Create required tables for users and employees
3. Update database connection details in the JDBC utility or DAO class

---

### Application Setup
1. Clone the repository from GitHub
2. Import the project into the IDE as a **Dynamic Web Project**
3. Configure **Apache Tomcat** in the IDE
4. Ensure servlet mappings are properly configured

---

### Running the Application
1. Start MySQL Server
2. Run the project on **Apache Tomcat**
3. Open a browser and access: http://localhost:8080/EmployeeManagementSystem/
4. Login using Admin or Employee credentials

---

## Testing
- Login and role-based access tested manually
- CRUD operations verified using UI and database records
- Session handling tested to prevent unauthorized access

---

## Learning Outcomes
- Practical understanding of **Servlet lifecycle**
- Hands-on experience with **JDBC**
- Understanding of **session management** and role-based access
- Experience building Java web applications

---

## Future Enhancements
- Migrate backend to **Spring Boot**
- Improve UI design
- Add pagination and search functionality

---

## Notes
This project was created mainly to practice **Servlets and JDBC** and to understand how Java-based web applications work internally.

---

## Author
**Venkat Prasad**

