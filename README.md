# Animal Management App – Installation and Configuration Guide

This document describes the architecture, configuration, and startup procedure for the multi-tier web application **Animal Management App**, developed as a semester project for the **PRO2** course.

The entire local development environment, including the database, is fully containerized using **Docker**. This ensures the application can be launched immediately with a single command, eliminating the need for any local database server installation.

---

## 1. Technologies and Architecture Overview
The application implements a classic, robust multi-tier (N-tier) architecture where data flows strictly from the presentation layer through the business logic down to the data persistence layer:

* **Presentation Layer:** Thymeleaf (HTML5 templates) + Bootstrap 5 + Spring Security Tags for dynamic UI rendering based on user permissions.
* **Service Layer (Business Logic):** Spring `@Service` components managed by the Spring IoC container to separate business logic from data access.
* **Data Access Layer:** Spring Data JPA utilizing the Hibernate ORM framework for transparent object-relational mapping.
* **Infrastructure:** Containerized MariaDB relational database running in an isolated Docker environment.
* **Security:** Spring Security providing database-driven authentication and password hashing via BCrypt.

---

## 2. Launching Infrastructure via Docker (Single Step)
The complete database infrastructure is defined in the `docker-compose.yml` file located in the root directory of the project. Spin up the entire environment by running a single command in your terminal:

```bash
docker-compose up -d