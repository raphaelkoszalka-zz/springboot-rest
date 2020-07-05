# Simple Spring Boot REST API

This is a simple example of a REST API built with SpringBoot.

There's only two endpoint (or primitive) that will receive a POST or a GET
if it's a POST it will persist either a city or a client.

## /v1/city/

### POST

#### #### http://localhost:8080/v1/city/new

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
	"name" : "Raphael",
	"gender" : "M",
	"birthdate" : "03/10/1988",
	"city" : "Blumenau"
}
```


### PUT 

####  http://localhost:8080/v1/client/update

```
{
	"name" : {USER_NEW_NAME},
	"gender" : "M",
	"birthdate" : "03/10/1988",
	"city" : "Blumenau",
    "id" : {USER_ID}
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

## Notes

If I had more time I would install and config Grafana to 'keep and eye' on the
server health. And also let it runnning at AWS, but my free tier is over :/

The idea is to let **utils** package running on a lambda server, so it would be up
only when requested, but since I ain't got no free tier account at AWS I just let it
be part of the microservice as a separated package.

To minimize at minimum collisions I am concatenating the URL plus Epoch timestamp
as the algorithm ID, and if is the same URL and timestamp it will just return the database
persisted shortened URL.

Since the microservice does not have user authentication it is stateless, or does not keep sessions,
but if auth would be need to keep it stateless I would use OAuth2 to avoid creating sessions and use 
JWT token instead.

## Doubts?
Just send me a message at rmkoszalka@gmail.com
