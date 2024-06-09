# Building web applications in Java with Spring Boot 3

A step-by-step guide to developing web applications using Spring Boot, the most popular framework for building Java applications. You'll learn about Spring Boot 3 and its role in enabling developers to deliver enterprise-grade applications. We'll dive into Spring's fundamentals by creating a REST API that communicates with a database and is supported by a comprehensive suite of tests. By the end of this course you will have learned what you need to start building your own web applications with Spring Boot 3.

## Agenda

- Module 1: Create the project
    - [start.spring.io](http://start.spring.io)
        - Java Build Tools (Maven + Gradle)
    - How to organize your code
        - Where your code should go (create a simple class)
        - No default package
    - How to run your application (IDE/Maven/Command Line)
    - Model
        - Run + Location Class
        - Records
    - Logging
    - Spring Boot DevTools
- Module 2: Web Application (REST API)
    - [Spring MVC](https://docs.spring.io/spring-framework/reference/web.html)
    - CRUD (in-memory)
    - @Component / Controller / RestController / Service / Repository
    - REST API Testing
        - Postman
        - Http Client (IntelliJ)
        - curl / HTTPie
    - Dependency Injection
    - Data Validation
    - Configuration
    - Error Handling
- Module 3: Database
    - H2 Database
    - JDBC Client (Keep it simple)
    - Command Line Runner
        - Loading JSON data
    - Docker Compose & PostgreSQL
    - Spring Data
- Module 4: REST Client
    - What is a client
        - Rest Template
        - WebClient
        - GraphQL Client
        - Rest Client
        - Http Interfaces
- Module 5: Testing
    - Spring Boot Testing Toolkit
        - No need to opt in to testing
        - `contextLoads()` test
        - `@SpringBootTest` annotation
        - Documentation
    - Writing Tests
        - `InMemoryRunRepositoryTest`
        - `RunControllerTest`
        - `RunControllerIntTest`
    - Spring Boot Slice Tests
        - `JDBCRunRepositoryTest`
    - Spring Rest Client Test
        - `UserRestClientTest`
- Resources

## Prerequisites

- Java Fundamentals (Beginner - Intermediate)
- JDK 17+
    - Check current version `java --version`
    - [SDKMAN](https://sdkman.io/)
- Java Build Tools (Maven / Gradle)
- IDE / Text Editor
    - [IntelliJ IDEA](https://www.jetbrains.com/idea/)
    - [Spring Tools](https://spring.io/tools)
        - Visual Studio Code
        - Eclipse
- API Testing Tool
    - Postman
    - Http Client (IntelliJ)
    - cURL / HTTPie
- [Docker Desktop](https://www.docker.com/)

## What is Spring?

- [What / Why Spring?](https://spring.io/)

## Resources

### Spring
- [Spring Academy](https://www.youtube.com/c/SpringAcademy)
- [Spring I/O](https://spring.io/blog)
- [Spring Blog](https://spring.io/blog)
- [SpringOne at VMware Explore](https://springone.io/)

### Documentation

- [Spring Framework Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Spring Framework API](https://docs.spring.io/spring-framework/docs/current/javadoc-api/)
- [Spring Boot Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/index.html)
- [Spring Boot API](https://docs.spring.io/spring-boot/docs/current/api/)
- [Spring Boot Guides](https://spring.io/guides)

### YouTube

- [Dan Vega](https://www.youtube.com/@danvega)
- [Spring Developer](https://www.youtube.com/@SpringSourceDev)
- [Josh Long](https://www.youtube.com/@coffeesoftware)
- [DaShaun Carter](https://www.youtube.com/@dashaun)
- [Spring Boot Learning](https://www.youtube.com/@SpringBootLearning)
- [Spring Tips](https://www.youtube.com/playlist?list=PLgGXSWYM2FpPw8rV0tZoMiJYSCiLhPnOc)
- [Amigoscode](https://www.youtube.com/@amigoscode)
- [Java Brains](https://www.youtube.com/c/JavaBrainsChannel)
- [Daily Code Buffer](https://www.youtube.com/@DailyCodeBuffer)