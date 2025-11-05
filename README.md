# Online Hardware and Software Support System

This is a **console-based application** built in **Java** to manage online support for hardware and software issues. It allows users to request support for hardware or software-related problems, and the system can store and retrieve support requests from a **MySQL** database via **JDBC** (Java Database Connectivity).

## Features

- **User Support Request**: Users can submit support requests for hardware or software issues.
- **Support Categories**: Separate categories for **Hardware** and **Software** issues.
- **Database Interaction**: MySQL database to store and manage support requests.
- **JDBC Connection**: The application uses JDBC to connect Java to a MySQL database.
- **Admin Dashboard**: Admin can view all the support requests and mark them as resolved or pending.

## Tech Stack

- **Java**: Core programming language.
- **JDBC**: Java Database Connectivity to connect Java with MySQL.
- **MySQL**: Database to store user and support request details.
- **Console-based**: Command-line interface for interaction.

## Prerequisites

Before you run the project, make sure you have the following installed on your system:

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (Java Development Kit) v8 or higher.
- [MySQL](https://dev.mysql.com/downloads/) (version 5.7 or higher).
- [JDBC Driver](https://dev.mysql.com/downloads/connector/j/) for MySQL.

## Database Setup

You need to set up a **MySQL** database to store support requests.

Setting Up the Project
1. Clone the repository
2. JDBC Connection Setup
3. Modify Database Configuration
4. Run the Application

##  Contributing

Feel free to fork this project and contribute by submitting pull requests. You can add new features, fix bugs, or improve the UI/UX for the system.

Fork the repository

Create a new branch (git checkout -b feature-name)

Make your changes

Commit your changes (git commit -am 'Add new feature')

Push to your forked repository (git push origin feature-name)

Create a pull request

