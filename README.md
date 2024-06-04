# **_SPRING BOOT Microservices_**
This repository contains the source code of the personal professional spring-boot-microservices project.

<!-- TOC -->
  * [Table of contents](#table-of-contents)
    * [Introduction](#introduction)
    * [Project: Structure & Architecture](#project--structure--architecture)
    * [Microservices](#microservices)
    * [technologies Used](#technologies-used)
    * [SetUp & Installation](#setup--installation)
      * [Prerequisites](#prerequisites)
      * [Clone Repository](#clone-repository)
      * [Configuration](#configuration)
      * [Build & Run](#build--run)
    * [Running the Application](#running-the-application)
      * [Using Docker](#using-docker)
      * [Using Kubernetes](#using-kubernetes)
    * [API Documentation](#api-documentation)
<!-- TOC -->


### Introduction
The "Online Shopping Application" is a microservices-based project designed to illustrate the implementation of microservices architecture, best practices, and patterns using Spring Boot. The application consists of several microservices that handle different aspects of an online shopping platform.

**Keyword:** service discovery, centralized configuration, distributed tracing, event driven architecture, centralized logging, circuit breaker, secure microservice using Keycloak.

### Project: Structure & Architecture
The project is organized into several modules, each representing a microservice:

online-shopping-application/

├── config-service/ # Configuration service

├── discovery-service/ # Service discovery (Eureka)

├── gateway-service/ # API Gateway

├── product-service/ # Product catalog service

├── order-service/ # Order processing service

├── inventory-service/ # Inventory management service

├── notification-service/ # Notification service

└── README.md # Project documentation

Here is the project Global architecture:

<img src="/home/saoussen/micoservices-parent/assets/architecture.png" title="The Project general architecture"/>

### Microservices

Each microservice is designed to handle s specific business function.

* *Product service:* create and view products, acts as product Catalog.
* *Order service:*  can order Products.
* *Inventory service:* can check if product is in stock or not.
* *Notification service:* can send notifications, after order is placed.

The Order service, Inventory service and Notification service are going to interact with each other in synchronous and asynchronous way

Here is the service architecture:

<img src="/home/saoussen/micoservices-parent/assets/service_archotecture.png" title="service general architecture"/>

### technologies Used
1. [x] ***Spring Boot*** - For building microservices.
2. [x] ***Spring Cloud*** - For distributed system patterns.
3. [x] ***Netflix Eureka*** - For service discovery.
4. [x] ***Spring Cloud Config*** - For centralized configuration management.
5. [x] ***Spring Cloud Gateway*** - For API gateway.
6. [x] ***Spring Data JPA*** - For data persistence.
7. [x] ***MySQL/MongoDb*** - For relational database and NoSQL database
8. [x] ***Docker*** - For containerization.
9. [x] ***Kubernetes*** - For orchestration.
10. [x] ***RabbitMQ/Kafka*** - For messaging.
11. [x] ***Keycloak*** - For securing microservices.
12. [x] ***Distributed Tracing*** - For tracing requests across services.
13. [x] ***Centralized Logging*** - For aggregating logs.
14. [x] ***Circuit Breaker*** - For handling service failures.

### SetUp & Installation

#### Prerequisites

* Java 17 or higher.
* Maven 2.6.4 or higher.
* Docker
* Kubernetes 

#### Clone Repository

`git clone https://github.com/AzouzSaoussen/online-shopping-application.git
cd online-shopping-application`

#### Configuration

* **Config Service:** Update the configuration files in the config-service/src/main/resources directory.
* **Database Configuration:** Update the database configurations in application.properties files for each microservice.

#### Build & Run

1. Build the project 

`mvn clean install `

2. Run the services

Start each service from its respective directory using Maven:

`mvn spring-boot:run`

### Running the Application

#### Using Docker

1. Build Docker images:
`docker-compose build`

2. Start the services:
`docker-compose up`

#### Using Kubernetes

Deploy the services to a Kubernetes cluster using the provided Kubernetes manifests in the k8s/ directory.

### API Documentation

Each microservice exposes a set of RESTful APIs. You can access the API documentation for each service at /swagger-ui.html

### Contributing

Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.


