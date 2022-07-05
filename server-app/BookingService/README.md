# Booking microservice

### Launching additional components

> requirements: [docker](https://docs.docker.com/get-docker/) and [docker-compose](https://docs.docker.com/compose/install/) installed

Containers can be launched using the `docker-compose` command in the `BookingService/docker` directory:

```bash
docker-compose -p tutio up --build -d
```

| component | management tool | credentials |
|:---:|:---:|:---:|
| database <br/>(PostgreSQL) | pgAdmin: <br/>http://localhost:9000 | pgAdmin: user@email.com/password <br/>db: user/password |
| message broker <br/>(RabbitMQ) | RabbitMQ Management: <br/>http://localhost:15672 | user/password |

### Launching the application

> requirements:
> - [Java JDK 17](https://openjdk.java.net/projects/jdk/17/) installed
> - containers of additional components have been launched (PostgreSQL, RabbitMQ)

The application can be launched using the [Gradle](https://gradle.org/) builder tool, by running the script in the main project directory `/BookingService`:

```bash
./gradlew bootRun
```

To check the status of the application, the `health` endpoint was created.
For the application running in a local environment, with the default port (8080):

```bash
curl http://localhost:8080/health
```

The application provides a scenario of the delivery of a new [`BookingProcessStarted`](domain/src/main/java/com/ddd/tutio/booking/event/BookingProcessStarted.java) domain event by requesting:

```bash
curl http://localhost:8080/booking-process-started
```

After receiving the request, information about creating a new event will appear in the application console.
Then information about the receipt of this event by the subscriber (at this stage, a reservation template is created and saved in the database) and the publication of a new event [`BookingCountdownStarted`](domain/src/main/java/com/ddd/tutio/booking/event/BookingCountdownStarted.java).

```
Produce event: com.ddd.tutio.booking.event.BookingProcessStarted
Consume event: com.ddd.tutio.booking.event.BookingProcessStarted
Produce event: com.ddd.tutio.booking.event.BookingCountdownStarted
```

The new booking template can be found in the database:

```sql
SELECT *
FROM booking.bookings
ORDER BY db_create_time LIMIT 1;
```

Using the ID of the found template, it is also possible to search for it via the service API, demonstrating the operation of the database repository adapter:

```bash
curl http://localhost:8080/booking-template/{bookingId}
```

A similar request was made available for the reservation aggregate, several example instances of which were created in the script [`/BookingService/docker/config/postgres/sql/03_example_init_values.sql`](docker/config/postgres/sql/03_example_init_values.sql). Sample request for one of them:

```bash
curl http://localhost:8080/booking/a8b7d555-368a-4eca-8d88-d341c7041a8d
```

In response, we get a JSON object with information about aggregate fields:

```json
{
  "bookingId": {
    "id": "a8b7d555-368a-4eca-8d88-d341c7041a8d"
  },
  "courseId": {
    "id": "f1c02c6c-6e8f-4091-b449-87524d972abd"
  },
  "pupilId": {
    "id": "bcc1e6c1-fe3c-408a-b667-af97abd01221"
  },
  "meetingDuration": {
    "startTime": "2022-03-20T08:30:00Z",
    "endTime": "2022-03-20T09:45:00Z"
  },
  "lessonPrice": {
    "price": 50,
    "currency": "PLN"
  },
  "status": "PLANNED",
  "events": []
}
```
