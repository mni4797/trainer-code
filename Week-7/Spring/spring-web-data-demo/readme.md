# Building a REST API with Spring Data and Spring Web

This is a demo of a restaurant review application built with spring data JPA and spring web

# Spring Data

[Tutorial](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa)

[Documentation](https://spring.io/projects/spring-data)

> Spring Data’s mission is to provide a familiar and consistent, Spring-based programming model for data access while still retaining the special traits of the underlying data store.

TLDR: Collection of projects that deal with the DB. Spring has a spring data flavor that works with specific database and means of interacting with a data source.

## Spring Data JPA

[Documentation](https://spring.io/projects/spring-data-jpa)

[Geeks for geeks](https://www.geeksforgeeks.org/spring-boot-spring-data-jpa/?ref=rp)

The DAO layer usually consists of a lot of boilerplate code that can and should be simplified. The advantages of such a simplification are many: a decrease in the number of artifacts that we need to define and maintain, consistency of data access patterns, and consistency of configuration.

Spring Data takes this simplification one step further and makes it possible to remove the DAO implementations entirely. The interface of the DAO is now the only artifact that we need to explicitly define.

## JPA

[Reference](https://www.geeksforgeeks.org/java-jpa-vs-hibernate/)

JPA stands for Java Persistence API (Application Programming Interface) JPAPI. JPA is only a specification, it is not an implementation. It is a set of rules and guidelines to set interfaces for implementing object-relational mapping.

ORM stands for Object Relational Mapper and they refer to software that automatically map data from the database to objects in our code.

Just like how JDBC has drivers, JPA has providers which are actual implementations, the most popular of which is Hibernate.

## JPA Annotations

To help aid our ORM in mapping our POJOs to data from DB we annotate our POJOs to tell the ORM which property matches to which column.

**@Entity** This annotation defines that a class can be mapped to a table

**@Id** This annotation specifies the primary key of the entity.

**@GeneratedValue** This annotation is used to specify the primary key generation strategy to use. i.e. Instructs database to generate a value for this field automatically. If the strategy is not specified by default AUTO will be used.

**@Transient** This annotation is used to specify to our ORM to ignore this column and to not persist it.

## Hibernate Annotations

We also use hibernate annotations alongside JPA annotations to further specify relationships between our objects

Multiplicity Annotations:

[Hibernate 1 To M](https://www.baeldung.com/hibernate-one-to-many)

**@OneToOne**, **@ManyToOne**, **@OneToMany**, **@ManyToMany**

Annotations for relational integrity:

**@JoinColumn**

# Spring Web MVC

Spring Web MVC is a model-view-controller web framework built on the Servlet API. This framework is useful for creating flexible web applications to handle HTTP requests from clients. Packaging for Spring MVC projects will be `war` packaging.

The Spring MVC web framework is designed around the front controller pattern where a central servlet, the `DispatcherServlet`, provides a shared algorithm for request processing, while actual work is performed by configurable delegate components. This model is flexible and supports diverse workflows.

![Front Controller Design Pattern](https://docs.spring.io/spring-framework/docs/3.0.0.M4/spring-framework-reference/html/images/mvc.png)

![Front controller DP simplified](https://www.codejava.net/images/articles/frameworks/spring/Understanding%20Spring%20MVC/FrontControllerDesignPattern.jpg)

Spring Boot provides the spring-boot-starter-web library for developing web applications using Spring MVC. One of the main features of Spring Boot is autoconfiguration. The Spring Boot autoconfiguration registers and configures the DispatcherServlet automatically. Therefore, we don’t need to register the DispatcherServlet manually.[Reference Article](https://www.baeldung.com/spring-boot-dispatcherservlet-web-xml)

## Spring MVC Annotations

- `@Controller`

  - A Spring stereotype annotation that is put at the class level for a presentation-layer class whose methods expose web endpoints.

- `@RequestMapping`

  - Used to expose a resource through a web endpoint
  - Does not specify a specific HTTP verb by default
  - `method` value can be provided to indicate a HTTP verb

- `@GetMapping`

  - Used to expose a resource through a web endpoint specific to HTTP GET requests

- `@PostMapping`

  - Used to expose a resource through a web endpoint specific to HTTP POST requests

- `@PutMapping`

  - Used to expose a resource through a web endpoint specific to HTTP PUT requests

- `@DeleteMapping`

  - Used to expose a resource through a web endpoint specific to HTTP DELETE requests

- `@PathVariable`

  - Used to grab a variable that is a part of the URI path

- `@RequestParam`

  - Used to grab a variable that is defined as a query parameter within the URI

- `@RequestBody`

  - Used to grab a object from the body of the web request

- `@ResponseBody`

  - Used to indicate that the returned value of the controller method will be placed within the body of the web response

- `@ResponseStatus`

  - Used to indicate the HTTP response status code for a controller method

- `@ExceptionHandler`

  - Used to send custom responses back to the client when a controller method throws a specified exception

- `@RestController`
  - Used when creating RESTful APIs using Spring MVC
  - An aggregate annotation that implies `@Controller` on the class level and `@ResponseBody` on each controller method

# Application.yml

Yaml format for application properties.
