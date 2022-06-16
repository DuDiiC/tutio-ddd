# Mikroserwis rezerwacji

### Uruchomienie dodatkowych komponentów

> wymagania: zainstalowany [docker](https://docs.docker.com/get-docker/) oraz [docker-compose](https://docs.docker.com/compose/install/)

Kontenery mogą zostać uruchomione z użyciem polecenia `docker-compose` w katalogu `/BookingService/docker`:

```bash
docker-compose -p tutio up --build -d
```

|             komponent             |             narzędzie do zarządzania             |                 dane uwierzytelniające                  |
|:---------------------------------:|:------------------------------------------------:|:-------------------------------------------------------:|
|   baza danych <br/>(PostgreSQL)   |       pgAdmin: <br/>http://localhost:9000        | pgAdmin: user@email.com/password <br/>db: user/password |
| broker wiadomości <br/>(RabbitMQ) | RabbitMQ Management: <br/>http://localhost:15672 |                      user/password                      |

### Uruchomienie aplikacji

> wymagania:
> - zainstalowana [Java JDK 17](https://openjdk.java.net/projects/jdk/17/)
> - uruchomione kontenery dodatkowych komponentów (PostgreSQL, RabbitMQ)

Aplikacja może zostać uruchomiona przy użyciu narzędzia budowania [Gradle](https://gradle.org/),
poprzez uruchomienie skryptu w głównym katalogu projektu `/BookingService`:

```bash
./gradlew bootRun
```

Aby sprawdzić status aplikacji, udostępniony został endpoint `health`.
Dla aplikacji uruchomionej w środowisku lokalnym, z domyślnym portem (8080):

```bash
curl http://localhost:8080/health
```

Aplikacja umożliwia symulację dostarczenia nowego zdarzenia domenowego `BookingProcessStarted` poprzez żądanie:

```bash
curl http://localhost:8080/booking-process-started
```

Po otrzymaniu żądania, w konsoli aplikacji pojawi się informacja o utworzeniu nowego zdarzenia.
Następnie informacja o odebraniu tego zdarzenia przez subskrybenta (na tym etapie tworzony jest szablon rezerwacji, zapisywany w bazie)
oraz opublikowaniu nowego zdarzenia `BookingCountdownStarted`.

```
Produce event: com.ddd.tutio.booking.event.BookingProcessStarted
Consume event: com.ddd.tutio.booking.event.BookingProcessStarted
Produce event: com.ddd.tutio.booking.event.BookingCountdownStarted
```

Nowy szablon rezerwacji można znaleźć w bazie danych, z użyciem skryptu:

```sql
SELECT *
FROM booking.bookings
ORDER BY db_create_time LIMIT 1;
```

Z użycie ID wyszukanego szablonu, możliwe jest również jej wyszukanie przez API serwisu, demonstrując działanie adaptera repozytorium bazy danych:

```bash
curl http://localhost:8080/booking-template/{bookingId}
```

Analogiczne żądanie udostępnione zostało dla agregatu rezerwacji, którego kilka przykładowych instancji utworzonych zostało w skrycie
`/BookingService/docker/config/postgres/sql/03_example_init_values.sql`. Przykładowe żądanie dla jednej z nich:

```bash
curl http://localhost:8080/booking/a8b7d555-368a-4eca-8d88-d341c7041a8d
```

W odpowiedzi otrzymujemy obiekt JSON z informacjami na temat pól agregatu:

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
