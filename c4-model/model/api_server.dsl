api_server = container "Aplikacja serwerowa" "Serwer API dla aplikacji klienckich w architekturze mikroserwisowej" "Java & Spring Platform" "server_app,spring_white,black_stroke,intensive_blue_background,light_gray_font" {
    api_gateway = component "Brama API" "Brama API, przechwytuje żądania od aplikacji zewnętrznych i przekazuje je do wybranych mikroserwisów" "Java & Spring Platform" "api_gateway,spring_green,gray_stroke,light_blue_background,black_font"
    authentication_ms = component "Mikroserwis uwierzytelniania" "Uwieżytelnianie użytkowników (JSON Web Token)" "Java, Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    registration_ms = component "Mikroserwis rejestracji" "Tworzenie i weryfikacja kont nowych użytkowników" "Java, Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    booking_ms = component "Mikroserwis rezerwacji" "Zapisywania ucznia na zajęcia, zmiany terminów zajęć i ich odwoływanie" "Java, Spring Platform" "microservice,spring_white,black_stroke,intensive_blue_background,light_gray_font"
    courses_management_ms = component "Mikroserwis zarzadzania kursami" "Operacje związane z tworzeniem, edytowaniem i usuwaniem kursów" "Java, Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    meetings_ms = component "Mikroserwis spotkań" "Proces przeprowadzenia spotkania" "Java, Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
    reviews_ms = component "Mikroserwis podsumowania spotkań" "Podsumowanie spotkań i wystawianie recenzji" "Java, Spring Platform" "microservice,spring_green,gray_stroke,light_blue_background,black_font"
}
