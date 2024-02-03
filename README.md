# Goods Store
RESTful API using Java Spring to manage products in the goods store.
## Features
- Display all available products;
- Display any product from the store by its ID;
- Create a new product;
- Update an existing product (its name, description, price and/or quantity);
- Delete any product from the store;
- Product order (changing its quantity).
## Project structure (3-layer architecture):
- Repository - Data access layer
- Service - Application logic layer
- Controllers - Presentation layer
## Technologies:
- Java 17
- Git
- Apache Maven
- MySQL
- Spring Framework
## How to run:
1) Run the SQL script in src/main/resources/init_db.sql to set up the store database
2) Configure src/main/resources/application.properties with your database URL, username, password and driver
3) Run the main method from GoodsStoreApplication class