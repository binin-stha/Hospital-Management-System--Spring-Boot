# Hospital Management System (Spring Boot)

A Spring Boot-based hospital management application built with Java and JPA/Hibernate. The project demonstrates common healthcare domain modeling concepts such as patients, doctors, appointments, insurance, and department relationships.

## Overview

This application is designed to manage core hospital operations, including:

- Patient records
- Doctor profiles and specializations
- Appointment scheduling
- Insurance association to patients
- Department and doctor assignment tracking
- Blood group-based reporting
- Pagination for patient listing

## Tech Stack

- Java 21
- Spring Boot 4.0.6
- Spring Data JPA
- PostgreSQL
- Maven
- ModelMapper
- Lombok

## Project Structure

```text
Hospital-Management-System--Spring-Boot/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/com/fine_x/hospitalManagement/
│   │   │   ├── config/
│   │   │   ├── controller/
│   │   │   ├── dto/
│   │   │   ├── entity/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── HospitalManagementApplication.java
│   │   └── resources/
│   │       └── data.sql
│   └── test/
│       └── java/com/fine_x/hospitalManagement/
├── .gitignore
├── .gitattributes
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Main Domain Entities

- Patient
  - personal details
  - birth date
  - email
  - gender
  - blood group
  - insurance link
  - appointment list
- Doctor
  - name
  - specialization
  - email
  - appointment list
- Appointment
  - appointment time
  - reason
  - patient
  - doctor
- Insurance
  - policy number
  - provider
  - valid date
- Department
  - department name
  - head doctor
  - assigned doctors

## APIs

The application exposes REST endpoints under the public/admin route patterns.

### Public endpoints

- GET /public/doctors
  - Returns the list of doctors.

- POST /public/appointments
  - Creates a new appointment for a patient with a doctor.

- GET /public/appointments
  - Fetches a patient profile (currently uses a sample patient ID for demonstration).

### Admin endpoints

- GET /admin/patients?page=0&size=10
  - Returns paginated patient records.

## Database Setup

This project is configured for PostgreSQL and includes sample seed data in `src/main/resources/data.sql`.

Create a PostgreSQL database and set the datasource configuration in `src/main/resources/application.properties` similar to:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_management
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Running the Project

### Prerequisites

- Java 21+
- Maven 3.9+
- PostgreSQL database

### Run locally

```bash
./mvnw clean install
./mvnw spring-boot:run
```

Then open the app on:

```text
http://localhost:8080
```

## Sample Data

The repository includes seed data for patients, doctors, and appointments in `src/main/resources/data.sql`, making it easy to test relationships and endpoints quickly.

## Notes

This project appears to be an educational or demo project for learning:

- Spring Boot REST APIs
- JPA entity relationships
- DTO mapping with ModelMapper
- repository query design
- relational database modeling in a healthcare context

## License

This project does not currently declare a license in the repository metadata.

## Contribution

If you want to expand the project, possible next steps include:

- add authentication and authorization
- implement patient/doctor CRUD endpoints
- add appointment status tracking
- build a frontend interface
- add validation and exception handling
- expose Swagger/OpenAPI docs

## Author

Repository owner: `binin-stha`

---

This README was generated based on the project structure and source code available in the repository.
