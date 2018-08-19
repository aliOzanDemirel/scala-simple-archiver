### Spring/Scala Web App Example

This simple archiver is an example project written with Scala, running on Undertow.
Other techs used are Spring Boot/Security/Data/Test, Thymeleaf, jQuery, H2, Maven and Docker.
Examples of below can be found in this project:

- Implementing login-logout with Spring security
- Using Spring's CSRF protection and how to post ajax request with CSRF enabled
- Configuring im-memory users and url matchers up to user roles
- Modifying static files' path in local environment for hot reloading
- Configuring HTTPS in Spring Boot and adding explicit HTTP listener for Undertow
- Using import.sql to automatically insert data to db schema which is created by Hibernate
- Using Thymeleaf with jQuery and its Spring integration for form actions and field errors
- How to upload or download files with Spring
- How to add custom logic by overriding default ErrorController in Spring
- Using Hibernate validation and entity mappings, writing custom Spring Validator
- Writing both integration and unit tests by using Spring test utilities
- Using maven to build project by running tests
- Using docker to generate and run JAR file in a container

##### How to run

| steps | docker           | maven  |  
| :---: | :--------------: | :---:  |
| build | docker build -t scala-archiver . | mvn clean install spring-boot:repackage
| run   | docker run -it -p 8080:8080 -p 8443:8443 --rm scala-archiver | java -Dspring.profiles.active=docker -jar scala-simple-archiver.jar

##### Screenshots

![alt text][categories]

![alt text][file-form]

[categories]: categories.png "Category List"
[file-form]: file-form.png "Add-Edit File Form"