api_server_v2 = container "Aplikacja serwerowa V2" "Serwer API dla aplikacji klienckich w architekturze mikroserwisowej" "Java & Spring Platform" "server_app,spring_white,black_stroke,intensive_blue_background,light_gray_font" {

    # generics microservices
    api_gateway_v2 = component "Brama API" "Brama API, przechwytuje żądania od aplikacji zewnętrznych i przekazuje je do wybranych mikroserwisów" "Java & Spring Platform" "api_gateway,spring_green,gray_stroke,light_blue_background,black_font"
    security_ms_v2 = component "Mikroserwis uwierzytelniania i autoryzacji" "Uwierzytelnianie użytkowników i autoryzacja żądań" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    registration_ms_v2 = component "Mikroserwis rejestracji" "Tworzenie i weryfikacja kont nowych użytkowników" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # booking
    booking_ms_v2 = component "Mikroserwis rezerwacji" "Zapisy, zmiany terminów i odwoływanie zajęć" "Java & Spring Platform" "microservice,spring_white,black_stroke,intensive_blue_background,light_gray_font"

    # meeting
    meetings_ms_v2 = component "Mikroserwis spotkań" "Zarządzanie procesem spotkania" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    reviews_ms_v2 = component "Mikroserwis podsumowania spotkań" "Podsumowanie spotkań i wystawianie recenzji" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # tutor profile
    courses_management_ms_v2 = component "Mikroserwis zarzadzania kursami" "Tworzenie, edytowanie i usuwanie kursów" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    tutor_profile_management_v2 = component "Mikroserwis zarządzania kontem nauczyciela" "Zarządzanie kontem nauczyciela" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # searching
    searching_ms_v2 = component "Mikroserwis wyszukiwarki" "Wyszukiwanie kursów i nauczycieli" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background, black_font"

    # payments
    payment_ms_v2 = component "Mikroserwis płatności" "Opłaty, zwroty, wypłacanie pieniędzy za zajęcia" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # calendar
    calendar_ms_v2 = component "Mikroserwis kalendarza" "Zarządzanie kalendarzem użytkownika, integracja z zewnętrznym API kalendarza" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"

    # chat
    chat_ms_v2 = component "Mikroserwis wiadomości tekstowych" "Konwersacje pomiędzy użytkownikami" "Java & Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background, black_font"
}