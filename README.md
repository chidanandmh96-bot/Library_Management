Library Management System

A simple Library Management REST API built using Java, Spring Boot, Spring Data JPA, and PostgreSQL.

Technologies Used
Java
Spring Boot
Spring Data JPA
PostgreSQL
REST API
Maven
Postman

Features
Add a book
Get all books
Get book by ID
Update book
Delete book

API Endpoints
Method	Endpoint	Description
POST	/books	Add a new book
GET	/books	Get all books
GET	/books/{id}	Get book by ID
PUT	/books/{id}	Update book
DELETE	/books/{id}	Delete book

Book Fields
id
title
author
price
category
Database

PostgreSQL database is used to store book information.

Project Structure
src
└── main
    ├── java
    │   └── com.example.librarymanagement
    │       ├── controller
    │       ├── entity
    │       └── repository
    └── resources
        └── application.properties
