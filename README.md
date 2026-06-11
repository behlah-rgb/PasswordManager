# Password Manager

A command-line password manager built in Java to practice object-oriented programming, file handling, and software design principles.

## Features

* Add credentials
* View saved credentials
* Search credentials
* Update usernames and passwords
* Delete credentials
* Persistent file storage
* Password generator
* Automatic loading and saving of data

## Project Structure

* **Main.java** – User interface and menu navigation
* **Credentials.java** – Credential model
* **PasswordManager.java** – Credential management operations
* **FileManager.java** – File persistence
* **PasswordGenerator.java** – Random password generation

## Technologies

* Java
* ArrayList
* BufferedReader / BufferedWriter
* Object-Oriented Programming

## Current Limitations

* Passwords are stored in plain text
* No encryption
* No master password authentication
* Single-user implementation

## Future Improvements

* Password strength checker
* Master password system
* Password hashing
* AES encryption
* Database integration