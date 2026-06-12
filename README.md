# Password Manager

A command-line password manager built in Java to practice object-oriented programming, file handling, authentication systems, and software architecture.

The application supports multiple users, persistent credential storage, credential management, and password generation through a menu-driven interface.

## Features

### Authentication

* Multi-user account creation
* User login system
* Credential access restricted to authenticated users

### Credential Management

* Add credentials
* View credentials
* Search credentials
* Update usernames and passwords
* Delete credentials

### Persistence

* Credentials are saved to files
* Data is automatically loaded on startup
* User accounts persist between program executions

### Password Generator

* Generate random passwords
* Customizable password generation logic

## Technologies Used

* Java
* Object-Oriented Programming
* ArrayList
* File I/O
* BufferedReader
* BufferedWriter
* Exception Handling

## Project Structure

### Main.java

Handles:

* User interaction
* Application flow
* Menu navigation

### Credentials.java

Represents a credential object containing:

* Service name
* Username
* Password

### PasswordManager.java

Handles credential-related operations:

* Add
* View
* Search
* Update
* Delete

### FileManager.java

Handles:

* File creation
* Loading data
* Saving data

### PasswordGenerator.java

Generates random passwords based on user requirements.

### Authentication Manager

Handles:

* User registration
* User login
* Account verification

## Concepts Practiced

* Classes and Objects
* Constructors
* Collections
* File Handling
* Authentication Systems
* Data Persistence
* Utility Classes
* Separation of Concerns
* Software Refactoring
* Basic Security Concepts

## Current Limitations

* Credentials for all users are stored in the same credentials file
* Passwords are stored in plain text
* No password hashing
* No encryption
* No password strength analysis
* No graphical user interface

## Planned Improvements

* User-specific credential vaults
* Password strength checker
* Password history tracking
* Password hashing
* AES encryption
* Secure credential storage
* JavaFX GUI
* Database integration

## Learning Objectives

This project was built incrementally to learn:

1. Core Java
2. Object-Oriented Programming
3. File Persistence
4. Authentication Systems
5. Software Design Principles
6. Security Fundamentals

## Future Roadmap

* V6: Password Hashing
* V7: AES Encryption
* V8: Database-backed Storage
