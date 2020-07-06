# Simple Spring Boot REST API

This is a simple example of a REST API built with SpringBoot.

## /v1/city/

### POST

#### http://localhost:8080/v1/city/new

```
{ "name": "Balneário Camboriú", "state": "Santa Catarina" }
```

### GET

#### http://localhost:8080/v1/city/city-name/{cityName} 
Will retrieve one city by it's name

#### http://localhost:8080/v1/city/state-name/{stateName} 
Will retrieve a list of cities within the provided state

## /v1/client/

### POST

####  http://localhost:8080/v1/client/new

```
{
    "name": "Raphael Koszalka",
    "gender": "M",
    "city": {
        "name": "Blumenau",
        "state": "Santa Catarina"
    },
    "birthdate": "03/10/1988"
}
```

### PUT 

####  http://localhost:8080/v1/client/update

```
{
    "id": 2,
    "name": {NEW_USER_NAME},
    "gender": "M",
    "city": {
        "name": "Blumenau",
        "state": "Santa Catarina"
    },
    "birthdate": "03/10/1988",
    "id": {USER_ID}
}
```

### GET

#### http://localhost:8080/v1/client/name/{clientName} 
Will retrieve one client by his/her name

#### http://localhost:8080/v1/client/id/{id} 
Will retrieve one client by his/her ID

### DELETE

#### http://localhost:8080/v1/client/id/{id} 
Will retrieve one client by his/her ID

## How to run

- Import the project into your IDE (it's preferable to be IntelliJ)
- Install Lombok Plugin for @Getter and @Setter annotation
- Enable annotation process at ```Editor > Compiler > Annotation Processors```
- bootRun the application (with Gradle)

When you bootRun for the first time the application will read db.changelog-master.yaml file @
resources/db folder and create the table and it's columns automatically, so you don't need to 
worry about SQL syntax for different databases, I chose PostgreSQL just because I am used to it, 
but it would work with MySQL or Oracle for example.

## Database
In this project I am using PostgreSQL, but since we are utilizing Liquibase, the database is agnostic.
You can choose which database you prefer.

### How to

```docker pull postgres```

Or download Docker PostgreSQL at: https://hub.docker.com/_/postgres.

Then for the first time, create the container with the following command.
```- docker run --name DB -e "POSTGRES_PASSWORD=postgres" -p 5432:5432 -d postgres```

The other times you just need to start the container with the following command:

``` docker start DB ```

After you start the database container you just need to create the "test" database.

``` create database test ```

When you bootRun the application, Spring Liquibase will read db.changelog-master.yaml and create
the necessary table and columns.

## Notes

To keep the complexity of this microservice as simple as it gets I chose to write both APIS at the same 
service instance.

For the same reasons I haven't wrote an error treatment for cases as deatacched entity when the user tries to
POST a new entity with and ID already set, for example.

User ID is only required when updating username.

Also I am not implementing a ModelMapper as I am used to do, just because as already stated, the goal was to 
provide a workable code without the need to increase it's complexity, since it's just a simple model of how
Spring Boot handle it's HTTP requests.

Since the microservice does not have user authentication it is stateless, or does not keep sessions,
but if auth would be need to keep it stateless I would use OAuth2 to avoid creating sessions and use 
JWT token instead.

## Doubts?
Just send me a message at rmkoszalka@gmail.com
