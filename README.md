# Java-API-Template

This project serves as a Java Spring Boot API template, equipped with essential resources to kickstart your development journey.

## Tecnologies
- Java 21
- Maven
- SpringBoot 3
- JPA
- PostgreSQL

## Getting Started
### Prerequisites

- Install Java version 21.

### Running Locally
1. Start the PostgreSQL database using docker-compose up -d.
2. Run the Spring Boot application with `mvn spring-boot:run`.

## Documentation
Explore the API documentation using Swagger. Access the resources at `{api-path}/swagger-ui/index.html`.

### Database
The project is configured to connect to a PostgreSQL database, version 16 (other versions should be validated). The Docker Compose file (docker-compose.yml) is provided for local API setup. The database settings are configured to connect to a database in a container (localhost), and you can adjust them in application.yml if needed.

#### Migration
This project uses [Liquibase](https://www.liquibase.org/) for database versioning and deployment. Migrations can be found in `resources/changelog`.

### Tests
The project includes both unit tests and integration tests. Follow the naming conventions (important) for test classes:
- Unit tests should end with 'Test'
- Integration tests should end with 'IT'

Integration tests utilize the [Testcontainers](https://testcontainers.com/) library to provide a database for testing.

#### Running Tests
- `./mvn test` to run unit tests
- `./mvn integration-test` to run integration tests

Feel free to explore, contribute and adapt this template to accelerate your API development process. Happy coding!