# Password Manager

A command-line password manager built in Java.

This project was created to learn object-oriented programming, file handling, and software development fundamentals. The application allows users to store, view, delete, and persist credentials between program executions.

## Features

- Store credentials
- View saved credentials
- Delete credentials
- Persistent storage using text files
- Automatic loading of saved credentials on startup
- Menu-driven CLI interface

## Technologies Used

- Java
- ArrayList
- File I/O
- BufferedReader
- BufferedWriter
- Object-Oriented Programming

## Project Structure

- Main.java - User interaction and application flow
- Credentials.java - Credential model
- FileManager.java - Loading and saving credentials

## How It Works

Credentials are stored in a text file using the format:

Service, Username, Password

Example:

Github, john123, password123
Gmail, john@gmail.com, mypassword

When the program starts, saved credentials are loaded into memory. When the program exits, credentials are written back to the file.

## Current Limitations

- Passwords are stored in plain text
- Single-user implementation
- No encryption
- No password generation
- No search functionality
- No editing of existing credentials

## Future Improvements

- Master password authentication
- Password hashing
- AES encryption
- Password generator
- Search credentials
- Edit credentials
- JavaFX graphical interface
- Database support

## Learning Objectives

This project demonstrates:

- Classes and objects
- Constructors
- Collections
- File handling
- Exception handling
- Basic software architecture
- Git and GitHub workflow