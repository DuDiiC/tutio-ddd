# Booking microservice

### Launching additional services

requirements: [docker](https://docs.docker.com/get-docker/) and [docker-compose](https://docs.docker.com/compose/install/) installed

The containers can be launched using a `docker-compose` in the `/BoogkingService/docker` catalog:

```bash
docker-compose -p tutio up --build -d
```

|           component            |             management tool             |                       credentials                       |
|:------------------------------:|:---------------------------------------:|:-------------------------------------------------------:|
|   database <br/>(PostgreSQL)   |   pgAdmin: <br/>http://localhost:9000   | pgAdmin: user@email.com/password <br/>db: user/password |
| message broker <br/>(RabbitMQ) | management: <br/>http://localhost:15672 |                      user/password                      |

### Launching the application

requirements: [Java JDK 17](https://openjdk.java.net/projects/jdk/17/) installed

The application can be launched using a gradle script in the `/BookingService` project catalog:

```bash
./gradlew bootRun
```

---

> For correct running the application requires the launch of additional components.
