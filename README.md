# Cinema

![Header Image](src/main/resources/cinema.png)

# Table of Contents

[Project purpose](#purpose)

[Project structure](#structure)

[For developer](#developer)

[Author](#author)

## <a name='purpose'></a>Project purpose

This project is a simple version of cinema.

<hr>

This cinema has basic functions such as:

Available functions for all users: 
* registration
* log in/log out
* view all movies, available movie sessions and cinema halls
  
Available functions for users with a USER role only: 
* add movie sessions in a cart
* view the shopping cart
* complete and view orders

Available functions for users with an ADMIN role only:
* add movies, movie sessions and cinema halls
* find user by email

<hr>

## <a name='structure'></a>Project structure

- Java 11
- Maven
- Spring Core/Web MVC/Security
- MavenCheckstylePlugin 3.1.1
- log4j 1.2.17

## <a name='developer'></a>For developer
To run this project you need to install:

- <a href="https://www.oracle.com/technetwork/java/javase/downloads/jdk11-downloads-5066655.html">Java 11</a>
- <a href="https://tomcat.apache.org/download-90.cgi">Tomcat</a>
- <a href="https://www.mysql.com/downloads/">MySQL 8</a>
- <a href="https://www.postman.com/">Postman</a>(for convenience)

<hr>

Add this project to your IDE as Maven project.

Add Java SDK 11 in project structure.

Configure Tomcat:
- Add artifact
- Add Java SDK 11

<hr>

 * Change a path to your Log file in **src/main/resources/log4j.properties** on line 7.

<hr>

To work with MySQL you need to:
- Configure file **src/main/resources/db.properties**
- Change url, username and password to match with MySQL in db.properties file.

<hr>
<p>By default there are one user with an USER role (login = "user", email = "user@i.ua", password = "1234")
and one user with an ADMIN role (login = "admin", email = "admin@i.ua", password = "1234")

## <a name='author'></a>Author
[Andrii Kutil](https://www.linkedin.com/in/andrii-kutil-567246179/)


