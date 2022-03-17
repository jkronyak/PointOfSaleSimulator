# PointOfSaleSimulator

Welcome to the PointOfSaleSimulator repository! This is a personal project of mine for the purpose of learning and integrating new technologies, 
researching and experimenting with different practices, and honing and refreshing my programming and development skills. Inspired by a past 
part-time job of mine as a customer service associate, this simple desktop application simulates transactional operations of a grocery store
point-of-sale system. My desire is to properly implement the Model-View-Controller pattern in a non-trivial way, and make use of a database. 
  
## Technologies  
This section will describe the technologies used and their purposes. 

### Java
PointOfSaleSimulator is written primary using the Java programming language, developed using JDK 16. Java was chosen simply because it was the language I was 
most familiar with when starting, and it remains so. Chosing a language which I am familiar with allows me to focus more on the interesting parts of the program.
Object-Oriented Programming is a paradigm I am familiar with and enjoy, I believe it to be useful when working with databases. 

### JavaFX
Coinciding with the use of Java, JavaFX is utilized for the front-end of this desktop application. It is new(ish), functional, and again I have some familiarity with it.
I primarily use SceneBuilder to generate the FXML files, though I am not a designer. 

### MySQL 
The PointOfSaleSimulator is backed by a MySQL Databasement, meant to familiarize myself with the actual process of managing a database effectively. 
MySQL is simply portable and relatively easy to use. I still hate the interface for MySQL Workbench. The database is used to persist simple information
about a store's items (i.e. plu, name, price). With expansion, the database with store past transactions, users such as employees, and perhaps more. 
The use of a database gives me ample practice implementing CRUD applications within the Java program. Currently, I utilize Database Access Objects, 
a packaged MySQLConnection, and database Seeding. 

### Maven 
This project also allowed me to practice making use of the Maven dependency management system, and I have appreciated its simplicity. I picked Maven 
simply for its popularity and ease of use.

## Planned Features
[-] Employee Login Validation
[-] Inventory Management System
[-] Transaction History
[-] Discounts/Sales
