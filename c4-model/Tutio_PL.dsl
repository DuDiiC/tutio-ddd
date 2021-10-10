workspace "Tutio" "Aplikacja korepetycji online" {

    model {

        # AKTORZY
        student = person "Uczeń" "użytkownik aplikacji, który chce się nauczyć pewnych umiejętności" "actor_yellow"
        tutor = person "Nauczyciel" "użytkownik aplikacji, który oferuje swoje umiejętności innym" "actor_yellow"

        # SYSTEMY
        tutio = softwareSystem "Platforma korepetycji online 'Tutio'" "" "platform,intensive_blue" {
            client_apps = container "Aplikacje klienckie" "Aplikacje webowe oraz mobilne dla ucznia i nauczyciela" "" "platform,light_blue" {
                student_front_end = component "Aplikacja webowa dla ucznia" "" "JavaScript & React.js" "web_app"
                student_mobile = component "Aplikacja mobilna dla ucznia" "Multiplatformowa dla systemów Android oraz iOS" "JavaScript & React Native" "mobile"
                tutor_front_end = component "Aplikacja webowa dla nauczyciela" "" "JavaScript & React.js" "web_app"
                tutor_mobile = component "Aplikacja mobilna dla nauczyciela" "Multiplatformowa dla systemów Android oraz iOS" "JavaScript & React Native" "mobile"
            }
            api_server = container "Aplikacja serwerowa" "Serwer API dla aplikacji klienckich w architekturze mikroserwisowej z komunikacją asynchroniczną opartą o system kolejkowy" "Java & Spring Platform" "server,intensive_blue" {
                api_gateway = component "Brama API" "Brama API, odpowiadająca za komunikację z aplikacjami zewnętrznymi, uwierzytelnianie oraz przekazywanie żądań do odpowiednich mikroserwisów" "???" "pipeline,light_blue"
                authentication_ms = component "Mikroserwis uwierzytelniania" "Odpowiada za uwierzytelnienie użytkowników" "Java, Spring Platform" "microservice,light_blue"
                registration_ms = component "Mikroserwis rejestracji" "Odpowiada za tworzenie kont nowych użytkowników, zarówno uczniów jak i nauczycieli" "Java, Spring Platform" "microservice,light_blue"
                booking_ms = component "Mikroserwis rezerwacji" "Odpowiada za proces zapisywania ucznia na zajęcia, zmiany terminów zajęć i ich odwoływanie" "Java, Spring Platform" "microservice,intensive_blue"
                courses_management_ms = component "Mikroserwis zarzadzania kursami" "Odpowiada za operacje związane z tworzeniem, edytowaniem i usuwaniem kursów nauczyciela" "Java, Spring Platform" "microservice,light_blue"
                meetings_ms = component "Mikroserwis spotkań" "Odpowiada za cały proces przeprowadzania spotkania" "Java, Spring Platform" "microservice,light_blue"
                reviews_ms = component "Mikroserwis podsumowania spotkań" "Odpowiada za podsumowanie spotkań i wystawianie recenzji" "Java, Spring Platform" "microservice,light_blue"
                message_broker = component "System kolejkowy" "" "Kafka" "pipeline,light_blue"
            }
            database = container "Baza danych" "" "Relacyjna - PostgreSQL" "database,light_blue"
        }
        streaming_server = softwareSystem "Usługa streamingowa [WebRTC]" "Serwer udostępniający połaczenie wideo, audio, udostępnianie ekranu oraz czat pomiędzy użytkownikami aplikacji" "server,gray"
        payment_service = softwareSystem "Usługa płatności  online [Stripe API]" "Odpowiada za pobieranie opłat od ucznia i przekazywania pieniędzy za lekcje do nauczyciela" "server,gray"
        notification_server = softwareSystem "System powiadomień [Mail & SMS]" "Odpowiada za wysyłanie użytkownikom powiadomień mailowych oraz SMS-owych" "server,gray"

        # POWIĄZANIA

        # użytkownicy z front-endem
        student -> student_front_end "Wyszukiwanie kursów, zapisy na nie, branie udziału w zajęciach, wystawianie opinii"
        tutor -> tutor_front_end "Zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"

        # użytkownicy z mobile
        student -> student_mobile "Wyszukiwanie kursów, zapisy na nie, branie udziału w zajęciach, wystawianie opinii"
        tutor -> tutor_mobile "Zarządzanie kursami, prowadzenie zajęć, tworzenie podsumowań"

        # użytkownicy z systemem powiadomień
        // notification_server -> student "Wysyłanie e-mail & SMS"
        // notification_server -> tutor "Wysyłanie e-mail & SMS"

        # użytkownicy z systemem płatności
        // payment_service -> tutor "Wypłata pieniędzy za zajęcia"
        // student -> payment_service "Pobranie opłat za zajęcia"

        # front i mobile z serwerem wideo
        student_front_end -> streaming_server "WebRTC [protokół SIP]"
        student_mobile -> streaming_server "WebRTC [protokół SIP]"
        tutor_front_end -> streaming_server "WebRTC [protokół SIP]"
        tutor_mobile -> streaming_server "WebRTC [protokół SIP]"

        # front, mobile i serwer wideo z serwerem aplikacji
        student_front_end -> api_gateway "[JSON/HTTPS]"
        student_mobile -> api_gateway "[JSON/HTTPS]"
        tutor_front_end -> api_gateway "[JSON/HTTPS]"
        tutor_mobile -> api_gateway "[JSON/HTTPS]"
        streaming_server -> api_gateway "[JSON/HTTPS]"

        # wysyłanie powiadomień
        message_broker -> notification_server "Żądanie wyłania powiadomień"

        # TODO - opanować jak to powinno wyglądać, bo teraz okrutny chaos
        # komunikacja mikroserwisów wewnątrz serwera
        api_gateway -> authentication_ms "Żądanie uwierzytelnienia"
        authentication_ms -> api_gateway "JWT"
        api_gateway -> registration_ms ""
        api_gateway -> booking_ms ""
        api_gateway -> courses_management_ms ""
        api_gateway -> meetings_ms ""
        api_gateway -> reviews_ms ""
        meetings_ms -> reviews_ms ""

        # system kolejkowy
        registration_ms -> message_broker "Publikuj"
        authentication_ms -> message_broker "Publikuj"
        booking_ms -> message_broker "Publikuj"
        meetings_ms -> message_broker "Publikuj"
        reviews_ms -> message_broker "Publikuj"

        # usługa płatności
        api_server -> payment_service "[JSON/HTTPS]"

        # baza danych
        api_server -> database ""
        database -> api_server ""
    }

    views {
        theme default

        # C1 lewo prawo
        systemLandscape {
            include *
            autolayout lr
        }

        # C1 góra dół
        systemContext tutio {
            include *
            autolayout tb
        }

        # C2 - widok ogólny
        container tutio {
            include *
            autolayout tb
        }

        # C3 - szczegóły aplikacji klienckich
        component client_apps {
            include *
            autolayout lr
        }

        # C3 - szczegóły serwera
        component api_server {
            include *
            autolayout lr
        }

        styles {
            # kształty
            element "platform" {
                shape Hexagon
            }
            element "web_app" {
                shape WebBrowser
                background #eeeeee
                stroke #3579F7
                color #111111
            }
            element "server" {
                shape Folder
            }
            element "mobile" {
                shape MobileDeviceLandscape
                background #eeeeee
                stroke #3579F7
                color #111111
            }
            element "database" {
                shape Cylinder
            }
            element "microservice" {
                shape Component
            }
            element "pipeline" {
                shape Pipe
            }
            # kolory
            element "gray" {
                background #aaaaaa
            }
            element "light_blue" {
                background #3579F7
                color #eeeeee
            }
            element "intensive_blue" {
                background #132E6A
                color #cccccc
            }
            element "actor_yellow" {
                background #fff9a6
                stroke #888888
                color #333333
            }
            # ikony elementów
            # TODO
        }
    }
}
