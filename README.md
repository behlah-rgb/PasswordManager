# Password Manager

A command-line password manager built in Java.

This project was created to strengthen Java fundamentals, object-oriented programming concepts, and file handling. Users can store, view, search, update, and delete credentials through a menu-driven interface. Credential data is persisted between program executions using file storage.

## Features

* Add new credentials
* View all saved credentials
* Search credentials by service name
* Update usernames and passwords
* Delete credentials
* Persistent storage using text files
* Automatic loading of credentials on startup
* Menu-driven CLI interface

## Technologies Used

* Java
* ArrayList
* File I/O
* BufferedReader
* BufferedWriter
* Object-Oriented Programming (OOP)

## Project Structure

### Main.java

Handles:

* User interaction
* Menu navigation
* Credential management operations

### Credentials.java

Represents a credential object containing:

* Service name
* Username
* Password

### FileManager.java

Handles:

* Creating the credentials file
* Loading credentials from storage
* Saving credentials to storage

## How It Works

Credentials are stored in a text file using the format:

Service, Username, Password

Example:

Github, john123, password123

Gmail, [john@gmail.com](mailto:john@gmail.com), mypassword

When the application starts, credentials are loaded into memory. When the application exits, the current credential list is saved back to the file.

## Concepts Practiced

* Classes and Objects
* Constructors
* Collections (ArrayList)
* File Handling
* Exception Handling
* Method Design
* Object References
* Data Persistence
* Basic Software Architecture

## Current Limitations

* Passwords are stored in plain text
* No encryption
* No password strength analysis
* No password generation
* No master password authentication
* Single-user implementation

## Planned Improvements

* Password generator using SecureRandom
* Password strength checker
* Master password authentication
* Password hashing
* AES encryption
* JavaFX graphical interface
* Database-backed storage
* Credential categories and tags

## Running the Project

1. Clone the repository.
2. Compile the Java files.
3. Run Main.java.
4. Use the menu to manage credentials.