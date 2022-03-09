api_server = container "Aplikacja serwerowa" "serwer API dla aplikacji klienckich w architekturze mikroserwisowej" "Java & Spring Platform" "server_app,spring_white,black_stroke,intensive_blue_background,light_gray_font" {

    # generics microservices
    api_gateway = component "Brama API" "brama API, przechwytująca żądania i przekazująca je do odpowiednich mikroserwisów" "Java & Spring Platform" "api_gateway,spring_green,gray_stroke,light_blue_background,black_font"
    security_ms = component "Mikroserwis uwierzytelniania i autoryzacji" "uwierzytelnianie użytkowników i autoryzacja żądań" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    registration_ms = component "Mikroserwis rejestracji" "tworzenie i weryfikacja kont nowych użytkowników" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # booking
    booking_ms = component "Mikroserwis rezerwacji" "zapisy, zmiany terminów i odwoływanie zajęć" "Java & Spring Platform" "microservice,spring_white,black_stroke,intensive_blue_background,light_gray_font"

    # meeting
    meetings_ms = component "Mikroserwis spotkań" "zarządzanie procesem spotkania" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    reviews_ms = component "Mikroserwis podsumowania spotkań" "podsumowanie spotkań i wystawianie recenzji" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # tutor profile
    courses_management_ms = component "Mikroserwis zarzadzania kursami" "tworzenie, edytowanie i usuwanie kursów" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    tutor_profile_management = component "Mikroserwis zarządzania kontem nauczyciela" "zarządzanie kontem nauczyciela" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # searching
    searching_ms = component "Mikroserwis wyszukiwarki" "wyszukiwanie kursów i nauczycieli" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background, black_font"

    # payments
    payment_ms = component "Mikroserwis płatności" "opłaty, zwroty, wypłacanie pieniędzy za zajęcia" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # calendar
    calendar_ms = component "Mikroserwis kalendarza" "zarządzanie kalendarzem użytkownika, integracja z zewnętrznym API kalendarza" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # chat
    chat_ms = component "Mikroserwis wiadomości tekstowych" "konwersacje pomiędzy użytkownikami" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background, black_font"
}